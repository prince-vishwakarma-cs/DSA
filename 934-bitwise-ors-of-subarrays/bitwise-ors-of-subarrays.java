class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> distinctOrValues = new HashSet<>();

        for (int i = 0; i < n; i++) {
            distinctOrValues.add(arr[i]); 

            for (int j = i - 1; j >= 0; j--) {
                if ((arr[j] | arr[i]) == arr[j]) {
                    break;
                }

                arr[j] |= arr[i];
                distinctOrValues.add(arr[j]);
            }
        }

        return distinctOrValues.size();
    }
}
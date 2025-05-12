class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n =digits.length;
        Set<Integer> set =new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i) continue;
                for(int k=0;k<n;k++){
                    if(k==j || k==i) continue;
                    if(digits[i]==0) continue;
                    if(digits[k]%2==1) continue;
                    set.add(digits[i]*100+digits[j]*10+digits[k]);
                }
            }
        }
        int[] arr = new int[set.size()];
        int i=0;
        for(int el:set){
            arr[i++]=el;
        }

        Arrays.sort(arr);

        return arr;
    }
}
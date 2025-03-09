class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int[] arr = new int[colors.length + k - 1];

        for (int p = 0; p < arr.length; p++) {
            arr[p] = colors[p % colors.length];
        }

        while (j < arr.length) {
            if ((j - i + 1) < k) {
                if (j < arr.length - 1) {
                    if (arr[j + 1] != arr[j]) {
                        j++;
                    } else {
                        i = j + 1;
                        j = i;
                    }
                } else {

                    break;
                }

            } else if ((j - i + 1) == k) {
                count++;
                i++;
                if (j < arr.length - 1 && arr[j + 1] != arr[j]) {
                    j++;
                }
            } else {
                i++;
            }
        }

        return count;
    }
}
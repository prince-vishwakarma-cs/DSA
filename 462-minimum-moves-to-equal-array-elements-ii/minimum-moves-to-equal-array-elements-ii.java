class Solution {
     public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            int mid1 = arr[n / 2 - 1];
            int mid2 = arr[n / 2];
            return (mid1 + mid2) / 2;
        }
    }
    public int minMoves2(int[] nums) {
        int median=findMedian(nums);
        int total=0;
        for(int n:nums){
            total+=Math.abs(n-median);
        }
        return total;
    }
}

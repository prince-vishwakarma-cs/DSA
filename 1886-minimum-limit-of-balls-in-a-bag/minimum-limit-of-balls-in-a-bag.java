class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int j = 0;
        for (int n : nums) j = Math.max(j, n);
        int i = 1;
        while (i < j) {
            int k=0;
            int mid = i + (j - i) / 2;
            for(int n:nums){
                if (n > mid) {
                    k += (n - 1) / mid; 
                }
        }
            if(k<=maxOperations) j=mid;
            else i=mid+1;
        }
        return j;
    }
}
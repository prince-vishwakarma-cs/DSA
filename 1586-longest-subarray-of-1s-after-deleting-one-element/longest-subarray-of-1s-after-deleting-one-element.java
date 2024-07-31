class Solution {
    public int longestSubarray(int[] nums) {
        int zero=nums[0]==0 ? 1: 0;
        int maxlength=1;
        int length=1;
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0) zero++;
            while(zero>1 && j<=i){
                if(nums[j]==0) zero--;
                length--;
                j++;
            }
            length++;
            maxlength=Math.max(length,maxlength);
        }
        return maxlength-1;
    }
}
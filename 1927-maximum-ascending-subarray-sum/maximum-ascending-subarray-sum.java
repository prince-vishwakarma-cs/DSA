class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=0;
        int last=-1;
        int max=0;
        for(int i=0;i<nums.length;i++){
        if(nums[i]>last) sum+=nums[i];
        else sum=nums[i];
        last=nums[i];
        max=Math.max(sum,max);
        }
        return max;
    }
}
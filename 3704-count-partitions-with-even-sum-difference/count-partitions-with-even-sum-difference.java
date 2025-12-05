class Solution {
    public int countPartitions(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            int prevsum=nums[i];
            int nextsum=nums[nums.length-1]-prevsum;
            if(Math.abs((prevsum-nextsum))%2==0) ans++;
        }
        return ans;
    }
}
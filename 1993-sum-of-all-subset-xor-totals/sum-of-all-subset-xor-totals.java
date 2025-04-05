class Solution {
    public void sum(int[] nums,int i,int curr,int[] total){
        if(i>=nums.length){
            total[0]+=curr;
            return ;
        }
        sum(nums,i+1,curr^nums[i],total);
        sum(nums,i+1,curr,total);
    }
    public int subsetXORSum(int[] nums) {
        int[] total = new int[]{0};
        sum(nums,0,0,total);
        return total[0];
    }
}
class Solution {
    public int minOperations(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1]=Math.abs(nums[i+1]-1);
                nums[i+2]=Math.abs(nums[i+2]-1);
                s++;
            }
        }
        for(int n:nums){
            if(n==0) return -1;
        }
        return s;
    }
}
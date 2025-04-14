class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;

        int currmax = nums[0];
        int currmin = nums[0];
        int max = nums[0];

        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp = currmin;
                currmin = currmax;
                currmax = temp;
            }

            currmax = Math.max(nums[i],nums[i]*currmax);
            currmin = Math.min(nums[i],nums[i]*currmin);

            max= Math.max(max,currmax);
        }

        return max;
    }
}
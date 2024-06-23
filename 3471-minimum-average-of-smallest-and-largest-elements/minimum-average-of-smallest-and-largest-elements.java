class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int i=0;int j=nums.length-1;
        double average=(double)(nums[j]+nums[i])/2.0;
        while(i<j){
            average=Math.min((double)(nums[i++]+nums[j--])/2.0,average);
            
        }
        return average;
    }
}
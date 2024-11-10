class Solution {
    public int maxFrequency(int[] nums, int k) {
        if(nums.length==1) return 1;
        Arrays.sort(nums);
        int i=0;
        long curr=k;
        int max=0;
        for(int j=0;j<nums.length-1;j++){
            while(curr<(long)(nums[j+1]-nums[j])*(j-i+1)){
                curr+=nums[j]-nums[i];
                i++;
            }
            curr-=(long)(nums[j+1]-nums[j])*(j-i+1);
            max=Math.max(max,j-i+2);
        }
        return max;
    }
}
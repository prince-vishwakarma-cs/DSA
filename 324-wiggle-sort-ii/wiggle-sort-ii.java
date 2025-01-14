class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int ans[]=new int[nums.length];
        int i=1;
        int j=nums.length-1;
        while(i<nums.length){
            ans[i]=nums[j];
            i+=2;
            j--;
        }
        i=0;
        while(i<nums.length){
            ans[i]=nums[j];
            i+=2;
            j--;
        }
        i=0;
        while(i<nums.length){
            nums[i]=ans[i];
            i++;
        }
    }
}
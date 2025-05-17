class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0;
        int k=0;
        int j=n-1;
        while(k<=j){
            if(nums[k]==0){
                swap(nums,i,k);
                i++;
                k++;
            }else if(nums[k]==1){
                k++;
            }else{
                swap(nums,k,j);
                j--;
            }
        }
    }

    public void swap(int[] nums,int j,int k){
        int temp = nums[j];
        nums[j]=nums[k];
        nums[k]=temp;
    }
}
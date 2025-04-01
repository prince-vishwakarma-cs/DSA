class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums,target,true),find(nums,target,false)};
    }

    public int find(int[] nums,int target,boolean isFirst){
        int idx=-1;
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid = (i+j)>>1;
            if(nums[mid]==target){
                idx=mid;
                if(isFirst) j=mid-1;
                else i=mid+1;
            } else if(nums[mid]<target) i=mid+1;
            else j=mid-1;
        }
        return idx;
    }
}
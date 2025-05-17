class Solution {
    public int splitArray(int[] nums, int k) {
        int i=0;
        int j=0;
        for(int s=0;s<nums.length;s++){
            i=Math.max(i,nums[s]);
            j+=nums[s];
        }
        int ans =0;
        while(i<=j){
            int mid =(i+j)>>1;
            if(splits(nums,mid)<=k){
                ans = mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }   
        return ans;
    }
    public int splits(int[] nums,int s){
        int n =nums.length;
        int split =0;
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=nums[i];
            if(curr>s){
                split++;
                curr=nums[i];
            }
        }
        return split+1;
    }
}
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int i =1;
        int n =nums.length;
        int j=0;
        int ans = Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            j =Math.max(j,nums[k]);
        }
        while(i<=j){
            int mid = (i+j)>>1;
            if(solve(nums,threshold,mid)) {
                ans = mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return ans;
    }


    public boolean solve(int[] nums,int threshold,int k){
        int n =nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=(nums[i]+k-1)/k;
        }
        return sum<=threshold;
    }
}
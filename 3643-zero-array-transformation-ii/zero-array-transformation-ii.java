class Solution {
    public boolean can(int[] nums,int[][] queries,int k){
        if(k>queries.length) return false;
        int[] pre=new int[nums.length+1];
        for(int i=0;i<k;i++){
            pre[queries[i][0]]+=queries[i][2];
            if(queries[i][1]+1<nums.length) pre[queries[i][1]+1]-=queries[i][2];
        }
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=pre[i];
            if(total>=nums[i]){
                nums[i]=0;
            }
            if(nums[i]!=0) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int l=0;int r=queries.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(can(nums.clone(),queries,mid)) r=mid;
            else l=mid+1;
        }
        if(!can(nums.clone(),queries,l)) return -1;
        return l;
    }
}
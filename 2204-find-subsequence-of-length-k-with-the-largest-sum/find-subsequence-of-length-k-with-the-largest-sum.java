class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n =nums.length;
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=nums[i];
        }
        Arrays.sort(arr2);
        int[] ans = new int[k];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=n-1;i>=0 && k>0 ;i--,k--){
            mp.put(arr2[i],mp.getOrDefault(arr2[i],0)+1);
        }
        int j=0;
        for(int i=0;i<n;i++){
            if(mp.getOrDefault(nums[i],0)>0){
                ans[j++]=nums[i];
                mp.put(nums[i],mp.get(nums[i])-1);
            }
        }
        return ans;
    }
}
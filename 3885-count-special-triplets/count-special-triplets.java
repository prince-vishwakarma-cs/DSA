class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer,Integer> mpleft =new HashMap<>();
        Map<Integer,Integer> mpright = new HashMap<>();
        int mod = 1000000007;
        long ans =0;
        for(int i=nums.length-1;i>=0;i--){
            mpright.put(nums[i],mpright.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            int target = curr*2;
            mpright.put(nums[i],mpright.get(nums[i])-1);
            int leftc = mpleft.getOrDefault(target,0);
            int rightc = mpright.getOrDefault(target,0);
            long sum = ((long)leftc*rightc)%mod;
            ans=((long)ans+sum)%mod;
            mpleft.put(nums[i],mpleft.getOrDefault(nums[i],0)+1);
        }
        return (int)ans;
    }
}
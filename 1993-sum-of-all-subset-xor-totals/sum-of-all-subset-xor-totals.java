class Solution {
    public int subsetXORSum(int[] nums) {
        int arb=0;
        for(int n:nums) arb|=n;
        return arb*(1<<(nums.length-1));
    }
}
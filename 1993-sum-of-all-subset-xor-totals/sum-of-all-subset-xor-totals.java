class Solution {
    public int subsetXORSum(int[] nums) {
        int arb=0;
        int p=nums.length-1;
        int total = 0;
        int pow = 1;
        for(int n:nums) arb|=n;
        return arb*(1<<p);
    }
}
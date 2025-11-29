class Solution {
    public int minOperations(int[] nums, int k) {
        int total =0;
        for(int n:nums){
            total+=n;
        }
        return total%k;
    }
}
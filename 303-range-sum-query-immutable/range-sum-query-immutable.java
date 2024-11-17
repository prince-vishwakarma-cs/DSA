class NumArray {
    int[] prefixSum;
    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        prefixSum=nums;
    }
    public int sumRange(int left, int right) {
        if(left>0) return prefixSum[right]-prefixSum[left-1];
        return prefixSum[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
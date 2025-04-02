class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long max=0L;
        Stack<Integer> st1= new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i=n-1;i>0;i--){
            if(st2.isEmpty() || nums[st2.peek()]<nums[i]) st2.push(i);
        }
        st1.push(0);
        for(int i=1;i<nums.length-1;i++){
            while(st2.peek()<=i) st2.pop();
            max = Math.max(max,((long)nums[st1.peek()]-(long)nums[i])*(long)nums[st2.peek()]);
            if(nums[i]>nums[st1.peek()]) st1.push(i);
        }
        return max;
    }
}
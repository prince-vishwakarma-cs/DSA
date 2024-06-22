class Solution {
    public int minOperations(int[] nums) {
        int flip=0;
        for(int n:nums){
            if(flip%2==1) n=Math.abs(n-1);
            if(n==0) flip++;
        }
        return flip;
    }
}
class Solution {
    public int minimumOperations(int[] nums) {
        int sum=0;
        for(int n:nums){
            if(n%3==1 || n%3==2) sum+=1;
        }
        return sum;
    }
}
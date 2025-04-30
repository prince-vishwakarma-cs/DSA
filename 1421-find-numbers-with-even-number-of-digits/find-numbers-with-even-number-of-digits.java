class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int el:nums){
            if(is(el)%2==0) count++;
        }
        return count;
    }

    public int is(int n){
        int count=0;
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }
}
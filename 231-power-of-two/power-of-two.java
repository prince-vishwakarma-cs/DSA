class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int set=0;
        for(int i=0;i<32;i++){
            if((n&(1<<i))!=0) set++;
        }
        return set==1;
    }
}
class Solution {
    public int[] sumZero(int n) {
        int[] res=new int[n];

        for(int i=0;i<n-1;i++){
            res[i]=i+1;
        }

        int val=((n-1)*(n))/2;
        res[n-1]=-val;
        return res;
    }
}
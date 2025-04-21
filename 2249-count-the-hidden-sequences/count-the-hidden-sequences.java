class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n =differences.length;
        long[] arr=new long[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=differences[i-1]+arr[i-1];
        }
        Arrays.sort(arr);
        int ans = (int)((upper-lower)+1-(arr[n]-arr[0]));
        return ans>0 ? ans : 0;
    }
}
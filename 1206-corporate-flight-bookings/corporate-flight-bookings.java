class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefix=new int[n];
        for(int[] b:bookings){
            prefix[b[0]-1]+=b[2];
            if(b[1]<n) prefix[b[1]]-=b[2];
        }
        for(int i=1;i<n;i++){
            prefix[i]+=prefix[i-1];
        }
        return prefix;
    }
}
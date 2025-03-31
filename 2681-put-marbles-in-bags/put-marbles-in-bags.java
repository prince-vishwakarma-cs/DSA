class Solution {
    public long putMarbles(int[] weights, int k) {
        long[] sum = new long[weights.length-1];
        for(int i=0;i<weights.length-1;i++){
            sum[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(sum);
        long minsum=0L;
        long maxsum=0L;
        for(int i=0;i<k-1;i++){
            minsum +=sum[i];
            maxsum+=sum[weights.length-2-i];
        }
        return maxsum-minsum;
    }
}
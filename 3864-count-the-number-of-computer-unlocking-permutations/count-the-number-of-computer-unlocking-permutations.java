class Solution {
    static final int MOD = 1000000007;
    static {
        for(int i = 0; i < 500; i++){
            countPermutations(new int[]{1,2,3});
        }
    }
    public static int countPermutations(int[] complexity) {
        int n = complexity.length;
        int min = complexity[0];

        for(int i = 1; i < n; i++){
            if(complexity[i] <= min) return 0;
        }

        long ans = 1;
        for(int i = 1; i < n; i++){
            ans = (ans * i ) % MOD;
        }

        return (int) ans;
    }
}
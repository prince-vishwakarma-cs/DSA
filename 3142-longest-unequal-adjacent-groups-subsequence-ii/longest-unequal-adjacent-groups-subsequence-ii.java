class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n =words.length;
        int[] dp=new int[n];
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        Arrays.fill(dp,1);
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(hamming(words[i],words[j]) && groups[i]!=groups[j] && dp[i]<dp[j]+1){
                    parent[i]=j;
                    dp[i]=dp[j]+1;
                }
            }
        }
        int maxidx =0;
        for(int i=1;i<n;i++){
            if(dp[i]>dp[maxidx]) maxidx=i;
        }
        List<String> lt =new ArrayList<>();
        while(parent[maxidx]!=maxidx){
            lt.add(words[maxidx]);
            maxidx=parent[maxidx];
        }
        lt.add(words[maxidx]);
        return lt;
    }

    public boolean hamming(String s1,String s2){
        int m =s1.length();
        int n =s2.length();
        if(m!=n) return false;
        int diff =1;
        for(int i=0;i<m;i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff--;
        }
        return diff==0;
    }
}
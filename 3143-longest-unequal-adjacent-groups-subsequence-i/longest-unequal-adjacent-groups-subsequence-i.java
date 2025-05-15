class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int last = 1-groups[0];
        int n = words.length;
        List<String> s = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(groups[i]!=last){
                s.add(words[i]);
                last=1-last;
            }
        }
        return s;
    }
}
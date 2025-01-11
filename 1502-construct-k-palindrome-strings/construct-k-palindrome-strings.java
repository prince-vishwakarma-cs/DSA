class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int total=0;
        int left_out=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                total+=freq[i];
                left_out+=freq[i]%2;
            }
        }
        if(total<k || left_out>k) return false;
        return true;
    }
}
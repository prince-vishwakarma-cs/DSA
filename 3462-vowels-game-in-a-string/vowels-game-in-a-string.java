class Solution {
    public boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i'  || c=='o'  || c=='u') return true;
        else return false;
    }
    public boolean doesAliceWin(String s) {
        int v=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))) v++;
        }
       if(v==0 )return false;
       else return true;
    }
} 
class Solution {
    public int minimumLength(String s) {
        char[] ca=s.toCharArray();
        int[] f=new int[26];
        int k=0;
        for(int i=0;i<ca.length;i++){
            f[ca[i]-'a']++;
            if(f[ca[i]-'a']==3){
                f[ca[i]-'a']-=2;
                k+=2;
            }
        }
        return s.length()-k;
    }
}
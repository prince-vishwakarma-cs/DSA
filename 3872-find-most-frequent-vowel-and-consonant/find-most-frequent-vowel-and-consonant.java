class Solution {
    public int maxFreqSum(String s) {
        int[] arr =new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        int maxvowel =0;
        int maxc =0;
        for(int i=0;i<26;i++){
            if(i==0 || i==4 || i==8 || i==14 || i==20){
                maxvowel = Math.max(maxvowel,arr[i]);
            }else{
                maxc = Math.max(maxc,arr[i]);
            }
        }
        return maxvowel+maxc;
        
    }
}


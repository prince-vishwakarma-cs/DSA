class Solution {
    public String getHint(String secret, String guess) {
        int l=secret.length();
        int x=0;
        int y=0;
        int[] freqs=new int[10];
        int[] freqg=new int[10];
        for(int i=0;i<l;i++){
            if(secret.charAt(i)==guess.charAt(i)) x++;
            else{
                freqs[secret.charAt(i)-'0']++;
                freqg[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            y+=Math.min(freqs[i],freqg[i]);
        }
        return String.valueOf(x)+"A"+String.valueOf(y)+"B";
    }
}
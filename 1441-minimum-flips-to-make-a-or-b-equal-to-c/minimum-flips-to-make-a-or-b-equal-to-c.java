class Solution {
    public int minFlips(int a, int b, int c) {
        int ans=0;
        for(int i=1;i<32;i++){
            int p=a&1;
            int q=b&1;
            int s=c&1;
            if(s==0){
                if(p==1 && q==1) ans+=2;
                else if(p==0 && q==0) ans+=0;
                else ans+=1;
            }else{
                if(p==0 && q==0) ans+=1;
            }
            a=a>>1;
            b=b>>1;
            c=c>>1;
        }
        return ans;
    }
}
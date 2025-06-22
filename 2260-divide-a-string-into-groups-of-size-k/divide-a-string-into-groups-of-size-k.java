class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        int n =sb.length();
        int req = k-(n%k);
        if(req<k){

        for(int i=1;i<=req;i++) sb.append(fill);
        }
        String[] sa = new String[sb.length()/k];
        int curr=0;
        for(int i=0;i<sa.length;i++){
            sa[i]=sb.substring(curr,curr+k);
            curr+=k;
        }
        return sa;
    }
}
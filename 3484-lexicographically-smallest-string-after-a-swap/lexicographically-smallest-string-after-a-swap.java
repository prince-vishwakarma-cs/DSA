class Solution {
    public boolean parity(char a,char b){
        int curr = Character.getNumericValue(a);
        int next = Character.getNumericValue(b);
        if((curr%2==0 && next%2==0) || (curr%2==1 && next%2==1)) return true;
        else  return false;
    }
    public String getSmallestString(String s) {
        char[] ca=s.toCharArray();
        for(int i=0;i<ca.length-1;i++){
            if(parity(ca[i],ca[i+1]) && ca[i]>ca[i+1]){
                char x=ca[i];
                ca[i]=ca[i+1];
                ca[i+1]=x;
                break;
            }
        }
        return String.valueOf(ca);
    }
}
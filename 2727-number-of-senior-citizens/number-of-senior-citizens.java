class Solution {
    public int sol(String details){
        String s=details.substring(11,details.length()-2);
        int n=Integer.parseInt(s);
        if(n>60) return 1;
        else return 0;
    }
    public int countSeniors(String[] details) {
        int ans=0;
        for(String s:details){
            ans+=sol(s);
        }
        return ans;
    }
}
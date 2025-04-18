class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s=countAndSay(n-1);
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<s.length()){
            int j=i;
            while(j<s.length() && s.charAt(i)==s.charAt(j))j++;
            sb.append(j-i);
            sb.append(s.charAt(i));
            i=j;
        }
        return sb.toString();
    }
}
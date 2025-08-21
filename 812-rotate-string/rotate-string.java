class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String t = s+s;
        System.out.println(t);
        for(int i=0;i<s.length();i++){
            if(t.substring(i,i+s.length()).equals(goal)) return true;
        }
        return false;
    }
}
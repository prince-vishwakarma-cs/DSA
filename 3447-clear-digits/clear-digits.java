class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        for(char i:s.toCharArray()){
            if(i>='a' && i<='z') st.push(i);
            else st.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
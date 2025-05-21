class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st =new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(st.isEmpty()) st.push(c);
            else{
                if(st.size()==1){
                    if(c==')') st.pop();
                    else{
                        sb.append(c);
                        st.push(c);
                    }
                }else{
                    sb.append(c);
                    if(c=='(') st.push(c);
                    else st.pop();
                }
            }
        }
        return sb.toString();
    }
}
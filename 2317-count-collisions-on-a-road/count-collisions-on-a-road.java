class Solution {
    public int countCollisions(String directions) {
        int n =directions.length();
        int collision = 0;

        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){

            char ch = directions.charAt(i);

            if(st.isEmpty()){
                st.push(ch);
                continue;
            } 
            char top =st.peek();
            if(top=='R' && ch=='L'){ // R-L collision
                st.pop();
                st.push('S');
                collision+=2;
            } else if(top=='R' && ch=='S'){ // R-S collision
                st.pop();
                st.push(ch);
                collision+=1;
            } else if(top=='S' && ch=='L') { // S-L collision
                collision+=1;
            } else {
                // no collison
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            char top = st.pop();
            if(st.isEmpty()) break;
            if(st.peek()=='R' && top =='S'){
                collision+=1;
                st.pop();
                st.push('S');
            }   
        }
        return collision;
    }
}
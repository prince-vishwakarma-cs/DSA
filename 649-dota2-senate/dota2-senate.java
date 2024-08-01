class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q=new LinkedList<>();
        char[] ca=senate.toCharArray();
        for(char c:ca){
            q.add(c);
        }
        int d=0;
        int r=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                char ch=q.poll();
                if(ch=='R'){
                    if(r>0) r--;
                    else{
                        d++;
                        q.add('R');
                    }
                }
                else{
                    if(d>0) d--;
                    else{
                        r++;
                        q.add('D');
                    }
                }
                if(r>q.size()) return "Dire";
                if(d>q.size()) return "Radiant";
            }
        }
        return q.poll()=='R' ? "Radiant" : "Dire";
    }
}
class Solution {
    public void ans(int[][] isConnected,int i,boolean[] visited){
        visited[i] =true;
        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                ans(isConnected,j,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        boolean[] visited=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                ans(isConnected,i,visited);
                ans++;
            }
        }
        return ans;
    }
}
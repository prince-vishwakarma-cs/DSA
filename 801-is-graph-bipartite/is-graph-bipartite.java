class Solution {
    public boolean dfs(int[][] graph,int[] vis,int curr,int color){
        vis[curr]=color;
        for(int i=0;i<graph[curr].length;i++){
            if(vis[graph[curr][i]]==color){
                return false;
            }
            if(vis[graph[curr][i]]==-1){
                if(dfs(graph,vis,graph[curr][i],1-color)==false) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] vis=new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++){
            if(vis[i]==-1){
                if(dfs(graph,vis,i,1)==false) return false;
            }
        }
        return true;
    }
}
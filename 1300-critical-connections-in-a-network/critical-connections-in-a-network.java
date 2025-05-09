class Solution {
    int time=0;
    int[] id;
    int[] low;
    List<List<Integer>> ans;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        id = new int[n];
        ans = new ArrayList<>();
        Arrays.fill(id,-1);
        low = new int[n];
        List<List<Integer>> adj =makeGraph(n,connections);
        for(int i=0;i<n;i++){
            if(id[i]==-1){
                scc(i,adj,-1);
            }
        }
        return ans;
    }
    
    public void scc(int node,List<List<Integer>> graph,int parent){
        id[node]=low[node]=time++;
        
        for(int neigh:graph.get(node)){
            if(id[neigh]==-1){
                scc(neigh,graph,node);
                low[node]=Math.min(low[node],low[neigh]);
                
                if(low[neigh]>id[node]) {
                    ans.add(new ArrayList<>());
                    int s = ans.size();
                    ans.get(s-1).add(neigh);
                    ans.get(s-1).add(node);
                }
            }
    else if (neigh != parent) {
    low[node] = Math.min(low[node], id[neigh]);
}


        }
    }
    
    public List<List<Integer>> makeGraph(int V,List<List<Integer>> edges){
        List<List<Integer>> lt =new ArrayList<>();
        for(int i=0;i<V;i++) lt.add(new ArrayList<>());
        for(List<Integer> edge:edges){
            int u =edge.get(0);
            int v =edge.get(1);
            lt.get(u).add(v);
            lt.get(v).add(u);
        }
        return lt;
    }
}

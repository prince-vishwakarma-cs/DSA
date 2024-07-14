class Solution {
    public void helper(List<List<Integer>> adj,boolean[] visited,int k){
        visited[k] = true;
        for (int i = 0; i < adj.get(k).size(); i++) {
            int neighbor = adj.get(k).get(i);
            if (!visited[neighbor]) {
                helper(adj, visited, neighbor);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        helper(rooms,visited,0);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false) return false;
        }
        return true;
    }
}
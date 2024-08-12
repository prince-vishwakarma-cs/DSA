class Solution {
    public int find(int A[], int X) {
        if (A[X] != X) {
            A[X]=find(A, A[X]);
        }
        return A[X];
    }
    public void unionSet(int A[], int X, int Z) {
        int rootX = find(A, X);
        int rootZ = find(A, Z);

        if (rootX != rootZ) {
            A[rootX] = rootZ;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int size=0;
        for(int[] edge:edges){
            size=Math.max(size,edge[0]);
            size=Math.max(size,edge[1]);
        }
        size++;
        int[] A=new int[size];
        for(int i=0;i<A.length;i++){
            A[i]=i;
        }
        for(int[] edge:edges){
            int node1=edge[0];
            int node2=edge[1];
            if(find(A,node1)==find(A,node2)) return edge;
            unionSet(A,node1,node2);
        }
        return new int[]{0,0};
    }
}
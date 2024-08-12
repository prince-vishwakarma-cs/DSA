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
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] A=new int[n];
        for(int i=0;i<A.length;i++){
            A[i]=i;
        }
        for(int[] edge:edges){
            unionSet(A,edge[0],edge[1]);
        }
        return find(A,source)==find(A,destination);
    }
}
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
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=i;
        }
        for(int[] edge:connections){
            int node1=edge[0];
            int node2=edge[1];
            unionSet(A,node1,node2);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(find(A,i)==i){
                ans++;
            }
        }
        return ans-1;
    }
}

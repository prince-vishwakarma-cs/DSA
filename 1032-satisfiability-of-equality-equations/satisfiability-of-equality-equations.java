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
    public boolean equationsPossible(String[] equations) {
        int[] A=new int[26];
        for(int i=0;i<A.length;i++){
            A[i]=i;
        }
        for(String s:equations){
            int node1=s.charAt(0)-'a';
            int node2=s.charAt(3)-'a';
            if(s.charAt(1)=='='){
                unionSet(A,node1,node2);
            }
        }
        for(String s:equations){
            int node1=s.charAt(0)-'a';
            int node2=s.charAt(3)-'a';
            if(s.charAt(1)=='!'){
                if(find(A,node1)==find(A,node2)) return false;
            }
        }
        return true;
    }
}
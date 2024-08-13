class Solution {
    public int find(int[] A, int X) {
        if (A[X] != X) {
            A[X] = find(A, A[X]);
        }
        return A[X];
    }

    public void unionSet(int[] A, int X, int Z) {
        int rootX = find(A, X);
        int rootZ = find(A, Z);

        if (rootX != rootZ) {
            A[rootX] = rootZ;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] A = new int[20002];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        for (int[] stone : stones) {
            unionSet(A, stone[0], stone[1] + 10001);
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(find(A, stone[1]+10001)); 
            uniqueRoots.add(find(A, stone[0]));
        }

        return n - uniqueRoots.size();
    }
}

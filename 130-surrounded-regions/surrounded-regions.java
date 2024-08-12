class Solution {
    public int find(int A[], int X) {
        if (A[X] != X) {
            A[X] = find(A, A[X]); // Path compression
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

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] parent = new int[m*n+1];
        int daddy = m*n;

        for (int i = 0; i < m*n; i++) {
            parent[i] = i;
        }
        parent[daddy] = daddy;
 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        unionSet(parent, i * n + j, daddy);
                    } else {
                        if (board[i - 1][j] == 'O') unionSet(parent, i * n + j, (i - 1) * n + j);
                        if (board[i + 1][j] == 'O') unionSet(parent, i * n + j, (i + 1) * n + j);
                        if (board[i][j - 1] == 'O') unionSet(parent, i * n + j, i * n + (j - 1));
                        if (board[i][j + 1] == 'O') unionSet(parent, i * n + j, i * n + (j + 1));
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && find(parent, i * n + j) != find(parent, daddy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

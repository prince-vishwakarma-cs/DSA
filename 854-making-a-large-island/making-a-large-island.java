class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        UnionFind2D uf = new UnionFind2D(m, n);
        int gmax = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) bfs(grid, i, j, visited, uf);
            }
        }

        // After BFS, count the size of each component
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = uf.find(i, j);
                    mp.put(root, mp.getOrDefault(root, 0) + 1);
                }
            }
        }

        // If all 1s
        for (int val : mp.values()) gmax = Math.max(gmax, val);

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenRoots = new HashSet<>();
                    int sum = 1; // flip this 0 to 1

                    for (int[] d : dir) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                            int root = uf.find(ni, nj);
                            if (seenRoots.add(root)) {
                                sum += mp.get(root);
                            }
                        }
                    }
                    gmax = Math.max(gmax, sum);
                }
            }
        }

        return gmax;
    }

    public void bfs(int[][] grid, int i, int j, boolean[][] visited, UnionFind2D uf) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int x = top[0], y = top[1];
            for (int[] dir : directions) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (newx >= 0 && newy >= 0 && newx < m && newy < n && !visited[newx][newy] && grid[newx][newy] == 1) {
                    visited[newx][newy] = true;
                    uf.union(x, y, newx, newy);
                    q.add(new int[]{newx, newy});
                }
            }
        }
    }
}

class UnionFind2D {
    private int[] parent;
    private int[] rank;
    private int rows, cols;

    public UnionFind2D(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        int size = rows * cols;
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int index(int row, int col) {
        return row * cols + col;
    }

    public int find(int row, int col) {
        int i = index(row, col);
        if (parent[i] != i) {
            int parentIndex = parent[i];
            parent[i] = find(parentIndex / cols, parentIndex % cols);
        }
        return parent[i];
    }

    public boolean union(int row1, int col1, int row2, int col2) {
        int root1 = find(row1, col1);
        int root2 = find(row2, col2);

        if (root1 == root2) return false;

        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }

        return true;
    }

    public boolean connected(int row1, int col1, int row2, int col2) {
        return find(row1, col1) == find(row2, col2);
    }
}

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        int [] sec=Arrays.copyOf(queries,queries.length);
        Arrays.sort(queries);
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
        boolean[][] visited = new boolean[m][n];

        visited[0][0] = true;
        pq.add(new int[]{0, 0, grid[0][0]});

        for (int i = 0; i < queries.length; i++) {
            while (!pq.isEmpty() && pq.peek()[2] < queries[i]) {
                sum += 1;
                int[] temp = pq.poll();
                int x = temp[0];
                int y = temp[1];

                for (int[] dir : direction) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        pq.add(new int[]{newX, newY, grid[newX][newY]});
                    }
                }
            }
            mp.put(queries[i], sum);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = mp.get(sec[i]);
        }
        return ans;
    }
}

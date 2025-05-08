class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0, 1});  // x, y, current time, step indicator (1 for 1-sec step, 2 for 2-sec step)
        
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], time = curr[2], step = curr[3];
            
            if (x == m - 1 && y == n - 1) return time;  // Reached target
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    int nextStepTime = step == 1 ? 2 : 1;  // Alternate step time
                    int moveCost = step;  // Current step time
                    int newTime = Math.max(time + moveCost, moveTime[nx][ny]+ moveCost);
                    pq.add(new int[]{nx, ny, newTime, nextStepTime});
                }
            }
        }
        
        return -1;  // If reaching (m-1, n-1) is impossible, return -1
    }
}

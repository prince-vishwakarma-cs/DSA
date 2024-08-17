class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        ArrayList<ArrayList<int[]>> lt = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lt.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            lt.get(edge[0]).add(new int[] { edge[2], edge[1] });
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        pq.add(new int[] {0,k});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[1];
            int d = top[0];
            for (int[] neighbor : lt.get(node)) {
                int neighbourNode = neighbor[1];
                int dist = neighbor[0];
                if (ans[neighbourNode] > d + dist) {
                    ans[neighbourNode] = d + dist;
                    pq.add(new int[] { ans[neighbourNode], neighbourNode});
                }
            }
        }
        int sol=Integer.MIN_VALUE;
        for (int j = 1; j <=n; j++) {
            sol = Math.max(sol, ans[j]);
        }
        return sol!=Integer.MAX_VALUE? sol:-1;
    }
}
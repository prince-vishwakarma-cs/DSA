class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        ArrayList<ArrayList<int[]>> lt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lt.add(new ArrayList<>());
        }
        for (int[] edge : flights) {
            lt.get(edge[0]).add(new int[] { edge[2], edge[1] });
        }
        int[][] ans = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[src][0] = 0;
        pq.add(new int[] { 0,src ,0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[1];
            int d = top[0];
            int stop=top[2];
            for (int[] neighbor : lt.get(node)) {
                int neighbourNode = neighbor[1];
                int dist = neighbor[0];
                if (stop<=k && ans[neighbourNode][stop] > d + dist) {
                    ans[neighbourNode][stop] = d + dist;
                    pq.add(new int[] { ans[neighbourNode][stop], neighbourNode ,stop+1});
                }
            }
        }
        int sol=Integer.MAX_VALUE;
            for(int j=0;j<ans[dst].length;j++){
                sol=Math.min(sol,ans[dst][j]);
        }
        return sol==Integer.MAX_VALUE? -1: sol;
    }
}

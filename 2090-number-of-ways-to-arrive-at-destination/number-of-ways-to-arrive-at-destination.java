import java.util.*;

class Solution {
    public ArrayList<ArrayList<int[]>> arrList(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] path : roads) {
            adj.get(path[0]).add(new int[]{path[1], path[2]});
            adj.get(path[1]).add(new int[]{path[0], path[2]});
        }
        return adj;
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = arrList(n, roads);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, 0});

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long currentDist = top[0];
            int currNode = (int) top[1];
            if (currentDist > dist[currNode]) {
                continue;
            } 
            for (int[] neighbor : adj.get(currNode)) {
                int nextNode = neighbor[0];
                long travelTime = neighbor[1];
                if (currentDist + travelTime < dist[nextNode]) {
                    dist[nextNode] = currentDist + travelTime;
                    pq.add(new long[]{dist[nextNode], nextNode});
                    ways[nextNode] = ways[currNode];
                }
                else if (currentDist + travelTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}

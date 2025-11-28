import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n == 1) { // Handle single-node edge case
            return values[0] % k == 0 ? 1 : 0;
        }

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] in = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
            in[u]++;
            in[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 1) {
                q.offer(i);
            }
        }

        int c = 0;
        while (!q.isEmpty()) {
            int f = q.poll();
            in[f] = 0;
            int remainder = values[f] % k;
            if (remainder == 0) {
                c++;
                values[f] = 0;
            }

            for (int neighbor : adj[f]) {
                if (in[neighbor] > 0) {
                    in[neighbor]--;
                    values[neighbor] = (values[neighbor] + remainder) % k;
                    if (in[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }

        return c;
    }
}

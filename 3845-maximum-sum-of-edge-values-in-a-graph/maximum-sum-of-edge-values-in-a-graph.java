import java.util.*;

class Solution {
    
    public boolean dfs(int i, int p, List<List<Integer>> adj, boolean[] vis, int[] cnt) {
        cnt[0]++;
        vis[i] = true;
        boolean ans = false;
        for (int j : adj.get(i)) {
            if (j == p) continue;
            if (vis[j]) ans = true;
            else ans |= dfs(j, i, adj, vis, cnt);
        }
        return ans;
    }

    public long maxScore(long n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        // Build the adjacency list
        for (int[] v : edges) {
            adj.get(v[0]).add(v[1]);
            adj.get(v[1]).add(v[0]);
        }

        boolean[] vis = new boolean[(int) n];
        List<Integer> cycles = new ArrayList<>();
        List<Integer> chains = new ArrayList<>();

        // Traverse the graph to classify cycles and chains
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int[] cnt = new int[1];
            if (dfs(i, -1, adj, vis, cnt)) cycles.add(cnt[0]);
            else chains.add(cnt[0]);
        }

        // Sort the cycles and chains in descending order
        Collections.sort(cycles, Collections.reverseOrder());
        Collections.sort(chains, Collections.reverseOrder());

        long ans = 0;

        // Process cycles
        for (int x : cycles) {
            ans += n * (n - 1 + n - 2);
            n -= 3; x -= 3;
            while (x > 0) {
                ans += n * (n + 2);
                x--; n--;
            }
            ans += (n + 1) * (n + 2);
        }

        // Process chains
        for (int x : chains) {
            if (x == 1) break;
            if (x == 2) {
                ans += n * (n - 1);
                n -= 2;
                continue;
            }
            ans += n * (n - 1 + n - 2);
            n -= 3; x -= 3;
            while (x > 0) {
                ans += n * (n + 2);
                x--; n--;
            }
        }

        return ans;
    }
}

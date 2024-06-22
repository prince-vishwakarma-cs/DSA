import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        Arrays.sort(arr, (a, b) -> (b[1] - a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() == k) {
                sum -= pq.poll();
            }
            pq.add(arr[i][0]);
            sum += arr[i][0];
            ans = Math.max(ans, sum * arr[i][1]);
        }
        
        return (int) (ans % 1_000_000_007);
    }
}

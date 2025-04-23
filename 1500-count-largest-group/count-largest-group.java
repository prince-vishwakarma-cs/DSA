public class Solution {
    public int sum(int k) {
        int total = 0;
        while (k > 0) {
            total += k % 10;
            k /= 10;
        }
        return total;
    }

    public int countLargestGroup(int n) {
        int[] group = new int[46]; 
        int maxCount = 0;

        for (int i = 1; i <= n; i++) {
            int s = sum(i);
            group[s]++;
            maxCount = Math.max(maxCount, group[s]);
        }

        int count = 0;
        for (int freq : group) {
            if (freq == maxCount) count++;
        }
        return count;
    }
}

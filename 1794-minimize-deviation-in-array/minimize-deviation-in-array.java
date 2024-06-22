import java.util.PriorityQueue;

public class Solution {
    public class Num {
        int val;
        public Num(int val) {
            this.val = val;
        }
        public Num() {
        }
    }

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add numbers to the heaps, making all numbers even
        for (int n : nums) {
            int value = (n % 2 == 0) ? n : n * 2;
            minHeap.add(value);
            maxHeap.add(value);
        }

        int ans = Integer.MAX_VALUE;

        while (true) {
            int maxVal = maxHeap.poll();
            int minVal = minHeap.peek();

            ans = Math.min(ans, maxVal - minVal);

            // Break the loop if the maximum value is odd
            if (maxVal % 2 == 1) break;

            // Otherwise, divide the maximum value by 2 and add back to heaps
            maxVal /= 2;
            minHeap.add(maxVal);
            maxHeap.add(maxVal);
        }

        return ans;
    }

}

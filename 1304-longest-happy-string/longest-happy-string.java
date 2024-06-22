class Solution {
    public class Pair {
        char key;
        int val;
        
        public Pair(char key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public String longestDiverseString(int a, int b, int c) {
        // Priority queue to keep characters sorted by count
        PriorityQueue<Pair> pq = new PriorityQueue<>((m, n) -> (n.val - m.val));
        
        // Add characters to priority queue if they have non-zero count
        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            
            // If the last two characters in the result are the same as current character, skip this one
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == first.key && sb.charAt(sb.length() - 2) == first.key) {
                if (pq.isEmpty()) break; // No more characters to add
                Pair second = pq.poll();
                sb.append(second.key);
                second.val--;
                if (second.val > 0) pq.add(second);
                pq.add(first); // Add back the first character to the queue
            } else {
                // Append the current character
                sb.append(first.key);
                first.val--;
                if (first.val > 0) pq.add(first); // Add back if count is still greater than 0
            }
        }
        
        return sb.toString();
    }
}

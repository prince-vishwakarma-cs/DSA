import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        char[] ca = senate.toCharArray();

        // Initialize the queue with the given senate characters
        for (char c : ca) {
            q.add(c);
        }

        // Tracks the number of bans pending for each party
        int radiantBan = 0;
        int direBan = 0;

        // Keep iterating until one party remains
        while (q.size() > 1) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                char ch = q.poll();
                if (ch == 'R') {
                    if (radiantBan > 0) {
                        radiantBan--;
                    } else {
                        direBan++;
                        q.add(ch);
                    }
                } else {
                    if (direBan > 0) {
                        direBan--;
                    } else {
                        radiantBan++;
                        q.add(ch);
                    }
                }
            }
            if (q.stream().allMatch(c -> c == 'R')) return "Radiant";
            if (q.stream().allMatch(c -> c == 'D')) return "Dire";
        }
        return q.peek() == 'R' ? "Radiant" : "Dire";
    }
}

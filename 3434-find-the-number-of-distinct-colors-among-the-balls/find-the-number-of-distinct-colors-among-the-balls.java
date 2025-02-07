class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Integer> ball_color = new HashMap<>();
        Map<Integer, Integer> color_freq = new HashMap<>();
        
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if (ball_color.containsKey(ball)) {
                int old_color = ball_color.get(ball);
                int old_color_freq = color_freq.get(old_color);
                
                if (old_color_freq == 1) {
                    color_freq.remove(old_color);
                } else {
                    color_freq.put(old_color, old_color_freq - 1);
                }
            }
            
            ball_color.put(ball, color);
            color_freq.put(color, color_freq.getOrDefault(color, 0) + 1);
            ans[i] = color_freq.size();
        }
        
        return ans;
    }
}

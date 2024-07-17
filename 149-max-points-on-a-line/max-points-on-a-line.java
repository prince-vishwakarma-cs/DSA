class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;

        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> mp = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double slope;
                    if (points[i][0] == points[j][0]) {
                        slope = Double.POSITIVE_INFINITY; // vertical line
                    } else {
                        slope = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                    }
                    mp.put(slope, mp.getOrDefault(slope, 0) + 1);
                }
            }
            for (int count : mp.values()) {
                if (count > max) {
                    max = count;
                }
            }
        }
        return max + 1;
    }
}

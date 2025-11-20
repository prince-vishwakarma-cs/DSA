class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];                  
        });

        List<Integer> ans = new ArrayList<>();
        int n = intervals.length;

        int last1 = intervals[n-1][0];
        int last2 = last1 + 1;
        ans.add(last1);
        ans.add(last2);

        for (int i = n - 2; i >= 0; --i) {
            int L = intervals[i][0], R = intervals[i][1];

            if (last1 >= L && last2 <= R) continue;

            if ((last1 >= L && last1 <= R) || (last2 >= L && last2 <= R)) {
                ans.add(L);
                last2 = last1;
                last1 = L;
            } else {
                ans.add(L);
                ans.add(L + 1);
                last1 = L;
                last2 = L + 1;
            }
        }

        return ans.size();
    }
}
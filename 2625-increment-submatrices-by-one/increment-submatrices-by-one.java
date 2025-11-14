class Solution {
    record Row (int d, int c0, int c1) {}
    public int[][] rangeAddQueries(int n, int[][] Q) {
        List<Row>[] rows = new List[n];
        for (int i = 0; i < n; i++) rows[i] = new ArrayList<>();

        for (var q : Q) {
            int r0 = q[0], c0 = q[1], r1 = q[2]+1, c1 = q[3]+1;
            rows[r0].add(new Row(1, c0, c1));
            if (r1 < n) rows[r1].add(new Row(-1, c0, c1));
        }

        int[][] res = new int[n][n];
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            for (var r : rows[i]) {
                diff[r.c0] += r.d;
                if (r.c1 < n) diff[r.c1] -= r.d;
            }

            res[i][0] = diff[0];
            for (int j = 1; j < n; j++) res[i][j] += res[i][j-1] + diff[j];
        }

        return res;
    }
}
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int current = dungeon[i][j];

                if (i == m - 1 && j == n - 1) {
                    dungeon[i][j] = Math.max(1, 1 - current);
                } else if (i == m - 1) {
                    dungeon[i][j] = Math.max(1, dungeon[i][j + 1] - current);
                } else if (j == n - 1) {
                    dungeon[i][j] = Math.max(1, dungeon[i + 1][j] - current);
                } else {
                    int minHealth = Math.min(dungeon[i + 1][j], dungeon[i][j + 1]);
                    dungeon[i][j] = Math.max(1, minHealth - current);
                }
            }
        }
        return dungeon[0][0];
    }
}

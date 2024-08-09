class Solution {
    public boolean isEqual(int[][] grid, int i, int j) {
        if (i + 2 >= grid.length || j + 2 >= grid[0].length)
            return false;
        for(int p=0;p<3;p++){
            for(int q=0;q<3;q++){
                if (grid[i+p][j+q]>9 || grid[i+p][j+q]<1) return false;
            }
        }
        Set<Integer> set=new HashSet<>();
        for(int p=0;p<3;p++){
            for(int q=0;q<3;q++){
                if(set.contains(grid[i+p][j+q])) return false;
                set.add(grid[i+p][j+q]);
            }
        }
        if(set.size()!=9) return false;
        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int sum8 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        if (sum1 != 15 || sum2 != 15 || sum3 != 15 || sum4 != 15 || sum5 != 15 ||sum6 != 15 ||sum7 != 15 ||sum8 != 15 ) return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isEqual(grid, i, j))
                    ans++;
            }
        }
        return ans;
    }
}
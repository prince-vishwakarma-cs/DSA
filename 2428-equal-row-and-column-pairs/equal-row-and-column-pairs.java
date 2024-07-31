import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        

        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                rowList.add(grid[i][j]);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }
        
        for (int j = 0; j < m; j++) {
            List<Integer> colList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                colList.add(grid[i][j]);
            }
            ans += rowMap.getOrDefault(colList, 0);
        }
        
        return ans;
    }
}

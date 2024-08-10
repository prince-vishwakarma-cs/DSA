class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;  // edge case if matrix is empty
        int n = matrix[0].length;
        
        int[][] gridright = new int[m][n];
        int[][] griddown = new int[m][n];
        
        // Populate the gridright array
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '0') 
                    gridright[i][j] = 0;
                else if (j + 1 < n && matrix[i][j + 1] == '1') 
                    gridright[i][j] = 1 + gridright[i][j + 1];
                else 
                    gridright[i][j] = 1;
            }
        }
        
        // Populate the griddown array
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '0') 
                    griddown[i][j] = 0;
                else if (i + 1 < m && matrix[i + 1][j] == '1') 
                    griddown[i][j] = 1 + griddown[i + 1][j];
                else 
                    griddown[i][j] = 1;
            }
        }
        
        int ans = 0;
        
        // Calculate the maximal rectangle
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int currWidth = gridright[i][j];
                
                for(int h = 0; h < griddown[i][j]; h++) {
                    currWidth = Math.min(currWidth, gridright[i + h][j]);
                    int area = (h + 1) * currWidth;
                    ans = Math.max(ans, area);
                }
            }
        }
        
        return ans;
    }
}

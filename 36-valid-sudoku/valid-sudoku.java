class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowwise = new int[9][9];
        int[][] columnwise = new int[9][9];
        int[][] blockwise = new int[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // Convert char to int
                    rowwise[i][num]++;
                    columnwise[j][num]++;
                    int blockIndex = (i / 3) * 3 + (j / 3);
                    blockwise[blockIndex][num]++;
                    
                    if (rowwise[i][num] > 1 || columnwise[j][num] > 1 || blockwise[blockIndex][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

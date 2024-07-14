class Solution {
    public void helper(int[][] arr, boolean[] visited, int row) {
        visited[row] = true;
        for (int col = 0; col < arr.length; col++) {
            if (arr[row][col] == 1 && !visited[col]) {
                helper(arr, visited, col);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int s = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                s++;
                helper(isConnected, visited, i);
            }
        }
        return s;
    }
}
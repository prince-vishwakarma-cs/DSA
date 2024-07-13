class Solution {
    public boolean exit(char[][] arr, int[] t, int[] ent) {
        if (t[0] == ent[0] && t[1] == ent[1])
            return false;
        else if (arr[t[0]][t[1]] == '.'
                && (t[0] == 0 || t[0] == arr.length - 1 || t[1] == 0 || t[1] == arr[0].length - 1))
            return true;
        else
            return false;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        visited[q.peek()[0]][q.peek()[1]] = true;
        int s = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int[] t = q.poll();
                if (exit(maze, t, entrance))
                    return s;
                if(t[0]>0 && maze[t[0]-1][t[1]]=='.' && !visited[t[0]-1][t[1]]){
                    q.add(new int[]{t[0]-1,t[1]});
                    visited[t[0]-1][t[1]] =true;
                }
                if(t[0]<maze.length-1 && maze[t[0]+1][t[1]]=='.' && !visited[t[0]+1][t[1]]){
                    q.add(new int[]{t[0]+1,t[1]});
                    visited[t[0]+1][t[1]] =true;
                }
                if(t[1]>0 && maze[t[0]][t[1]-1]=='.' && !visited[t[0]][t[1]-1]){
                    q.add(new int[]{t[0],t[1]-1});
                    visited[t[0]][t[1]-1] =true;
                }
                if(t[1]<maze[0].length-1 && maze[t[0]][t[1]+1]=='.' && !visited[t[0]][t[1]+1]){
                    q.add(new int[]{t[0],t[1]+1});
                    visited[t[0]][t[1]+1] =true;
                }
            }
            s++;
        }
        return -1;
    }
}
class Solution {
    public boolean isCycle(List<List<Integer>> graph, boolean[] visited, int i, boolean[] inRecursion) {
        visited[i] = true;
        inRecursion[i] = true;
        for (int neigh : graph.get(i)) {
            if (inRecursion[neigh])
                return true;
            else if (!visited[neigh])
                if (isCycle(graph, visited, neigh, inRecursion))
                    return true;
        }
        inRecursion[i] = false; 
        return false;
    }

    public List<List<Integer>> makeGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = makeGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycle(graph, visited, i,inRecursion))
                    return false;
            }
        }
        return true;
    }
}
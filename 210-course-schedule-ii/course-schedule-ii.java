
    class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            l.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            l.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        int[] ans = new int[numCourses];
        int s = 0;
        
        while (!q.isEmpty()) {
            int t = q.poll();
            ans[s] = t;
            s++;
            for (int neighbor : l.get(t)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        if (s == numCourses) {
            return ans;
        } else {
            return new int[0]; // Return an empty array if a cycle is detected
        }
    }
    }
    


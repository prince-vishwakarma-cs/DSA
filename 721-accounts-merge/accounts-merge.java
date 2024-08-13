import java.util.*;

class Solution {
    public int find(int A[], int X) {
        if (A[X] != X) {
            A[X] = find(A, A[X]);
        }
        return A[X];
    }

    public void unionSet(int A[], int X, int Z) {
        int rootX = find(A, X);
        int rootZ = find(A, Z);

        if (rootX != rootZ) {
            A[rootX] = rootZ;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> mp = new HashMap<>();
        int[] A = new int[accounts.size()];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String el = accounts.get(i).get(j);
                if (mp.containsKey(el)) {
                    unionSet(A, i, mp.get(el));
                } else {
                    mp.put(el, find(A, i));
                }
            }
        }
        List<List<String>> lt = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            lt.add(new ArrayList<>());
        }
        mp.forEach((email, accountIndex) -> {
            int root = find(A, accountIndex);
            lt.get(root).add(email);
        });
        for (int i = 0; i < lt.size(); i++) {
            if (!lt.get(i).isEmpty()) {
                Collections.sort(lt.get(i));
                lt.get(i).add(0, accounts.get(i).get(0));
            }
        }
        lt.removeIf(List::isEmpty);

        return lt;
    }
}

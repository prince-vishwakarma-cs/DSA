class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Map<Integer, int[]> mp = new HashMap<>();
        int[] ans = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            ans[i] = positions[i];
        }
        for (int i = 0; i < positions.length; i++) {
            mp.put(positions[i], new int[]{healths[i], directions.charAt(i)});
        }
        Arrays.sort(positions);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < positions.length; i++) {
            char dir = (char) mp.get(positions[i])[1];
            if (dir == 'R') {
                st.push(positions[i]);
            } else {
                while (!st.isEmpty() && mp.get(st.peek())[1] == 'R' && mp.get(st.peek())[0] < mp.get(positions[i])[0]) {
                    st.pop();
                    mp.get(positions[i])[0]--;
                }
                if (!st.isEmpty() && mp.get(st.peek())[1] == 'R') {
                    if (mp.get(st.peek())[0] > mp.get(positions[i])[0]) {
                        mp.get(st.peek())[0]--;
                    }
                    else st.pop();
                } else{
                    st.push(positions[i]);
                }
            }
        }
        while (!st.isEmpty()) {
            mp.get(st.pop())[1] = 'G';
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            if (mp.get(ans[i])[1] == 'G') list.add(mp.get(ans[i])[0]);
        }
        return list;
    }
}

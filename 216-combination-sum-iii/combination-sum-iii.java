class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        helper(k, target, 1, lt, list, new int[] { 0 });
        return list;
    }
    public void helper(int k, int n, int s, List<Integer> l, List<List<Integer>> list, int[] cs) {
        if (l.size()==k && cs[0] == n) {
            list.add(new ArrayList<>(l));
            return;
        }
        if (cs[0] > n)
            return;
        for (int i = s; i < 10; i++) {
            l.add(i);
            cs[0] += i;
            helper(k, n, i + 1, l, list, cs);
            l.remove(l.size() - 1);
            cs[0] -= i;
        }
    }
}
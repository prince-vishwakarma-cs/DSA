
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, lt, list,new int[]{0});
        return list;
    }


    public void helper(int[] candidates, int k, int s, List<Integer> l, List<List<Integer>> list, int[] cs) {
        if (cs[0] == k){
    list.add(new ArrayList<>(l));
    return;
}
        if (cs[0] > k) return;
        for (int i = s; i < candidates.length; i++) {
            if(i>s && candidates[i]==candidates[i-1]) continue;
            l.add(candidates[i]);
            cs[0] += candidates[i];
            helper(candidates, k, i+1 , l, list, cs);
            l.remove(l.size() - 1);
            cs[0] -= candidates[i];
        }
    }
}
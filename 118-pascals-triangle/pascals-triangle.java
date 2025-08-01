class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> list=new ArrayList<>();
            list.add(1);
            for(int j=1;j<i-1;j++){
                list.add(ans.get(ans.size()-1).get(j-1)+ans.get(ans.size()-1).get(j));
            }
            if(i>1) list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
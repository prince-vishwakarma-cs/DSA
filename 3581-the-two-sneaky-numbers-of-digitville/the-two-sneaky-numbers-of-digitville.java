class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans=new int[2];
        Set<Integer> set=new HashSet<>();
        int i=0;
        for(int n:nums){
            if(set.contains(n)) ans[i++]=n;
            set.add(n);
        }
        if(ans[0]>ans[1]) return new int[]{ans[1],ans[0]};
        return ans;
    }
}
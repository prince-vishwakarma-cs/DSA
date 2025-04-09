class Solution {
    public int minOperations(int[] nums, int k) {
        boolean lessExist = false;
        Set<Integer> set = new HashSet<>();
        for(int el:nums){
            if(el<k) lessExist=true;
            else if(el>k){
                set.add(el);
            }
        }
        if(!lessExist) return set.size();
        return -1;
    }
}
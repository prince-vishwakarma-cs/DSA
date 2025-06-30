class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        int[] max=new int[1] ;
        mp.forEach((key,value)->{
            if(mp.containsKey(key+1)){
                max[0]=Math.max(max[0],value+mp.get(key+1));
            }
        });
        return max[0];
    }
}
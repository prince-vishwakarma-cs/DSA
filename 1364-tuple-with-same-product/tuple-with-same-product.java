class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int product = nums[i]*nums[j];
                if(mp.containsKey(product)) ans+=8*mp.get(product);
                mp.put(product,mp.getOrDefault(product,0)+1);
            }
        }
        return ans;
    }
}
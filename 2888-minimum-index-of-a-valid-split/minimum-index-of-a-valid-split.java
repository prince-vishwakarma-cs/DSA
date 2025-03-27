class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        int max=nums.get(0);
        Map<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums.get(i),mp.getOrDefault(nums.get(i),0)+1);
            if(mp.get(nums.get(i))>mp.get(max)) max=nums.get(i);
        }
        int freq=mp.get(max);
        int curr=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==max){
                freq--;
                curr++;
            }
            int leftsize = i+1;
            int rightsize = n-i-1;
            if( curr>(leftsize/2) && freq>(rightsize)/2){
                return i;
            }
        }
        return -1;
    }
}
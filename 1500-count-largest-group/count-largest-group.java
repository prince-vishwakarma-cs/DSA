class Solution {
    public int sum(int k){
        int total = 0;
        while(k>0){
            total+=k%10;
            k/=10;
        }
        return total;
    }
    public int countLargestGroup(int n) {
        Map<Integer,Integer> mp =new HashMap<>();
        int maxCount=0;
        for(int i=1;i<=n;i++){
            int sum = sum(i);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
            if(mp.get(sum)>maxCount) maxCount=mp.get(sum);
        }
        int count=0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue()==maxCount) count++;
        }
        return count;
    }
}
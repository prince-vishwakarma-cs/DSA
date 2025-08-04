class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp=new HashMap<>();
        int i=0;
        int j=0;
        int maxlen=0;
        while(j<fruits.length){
            mp.put(fruits[j],mp.getOrDefault(fruits[j],0)+1);
            while(mp.size()>2){
                if(mp.get(fruits[i])==1) mp.remove(fruits[i]);
                else mp.put(fruits[i],mp.get(fruits[i])-1);
                i++;
            }
            if(j-i+1 > maxlen) maxlen=j-i+1;
            j++;
        }
        return maxlen;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        List<Integer> lt=new ArrayList<>();
        int li=0;
        Set<Character> set =new HashSet<>();
        for(int i=0;i<s.length();i++){
            char el=s.charAt(i);
            set.add(el);
            mp.put(el,mp.get(el)-1);
            if(mp.get(el)==0) set.remove(el);
            if(set.isEmpty()){
                lt.add(i+1-li);
                li=i+1;
            }
        }
        return lt;
    }
}
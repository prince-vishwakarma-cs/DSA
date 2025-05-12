class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        List<Integer> lt =new ArrayList<>();
        for(int el:digits) freq[el]++;
        for(int i=1;i<=9;i++){
            if(freq[i]==0) continue;
            freq[i]--;
            for(int j=0;j<=9;j++){
                if(freq[j]==0) continue;
                freq[j]--;
                for(int k=0;k<=8;k+=2){
                    if(freq[k]==0) continue;
                    freq[k]--;
                    lt.add(i*100+j*10+k);
                    freq[k]++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        int s =lt.size();
        int[] arr= new int[s];
        for(int i=0;i<s;i++){
            arr[i] = lt.get(i);
        }
        return arr;
    }
}
class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        int i=arr.length-1;
        int ans=0;
        while(i>=0 && arr[i]>0){
            if(i>17) ans+=1*arr[i];
            else if(i>9) ans+=2*arr[i];
            else if(i>1) ans+=3*arr[i];
            else ans+=4*arr[i];
            i--;
        }
        return ans;
    }
}
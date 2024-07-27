class Solution {
    public int maximum(int[] arr,int i,int canBuy,int k,Map<String,Integer> mp){
        if(i>=arr.length || k==0) return 0;

String key = i + "can" + canBuy + "hi" + k;
if(mp.containsKey(key)) return mp.get(key);
int max=0;
if(canBuy==1){
    int buy=maximum(arr,i+1,0,k,mp)-arr[i];
    int nobuy=maximum(arr,i+1,1,k,mp);
    max=Math.max(buy,nobuy);
} else{
    int sell=maximum(arr,i+1,1,k-1,mp)+arr[i];
    int nosell=maximum(arr,i+1,0,k,mp);
    max=Math.max(sell,nosell);
}
mp.put(key,max);
return max;
    }
    public int maxProfit(int k, int[] prices){
        Map<String,Integer> mp=new HashMap<>();
        return Math.max(0,maximum(prices,0,1,k,mp));
    }
}
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i=0, sum=0, ans=0,j=0;
        for(;j<k;j++){
            sum+=arr[j];
        }
        if((double)sum/k >= threshold) ans+=1;
        while(j<arr.length){
            sum-=arr[i];
            i++;
            sum+=arr[j];
            if((double)sum/k >= threshold) ans+=1;
            j++;
        }
        return ans;
    }
}
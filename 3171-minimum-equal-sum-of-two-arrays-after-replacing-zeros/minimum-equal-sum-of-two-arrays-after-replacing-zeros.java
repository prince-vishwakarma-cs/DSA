class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int m =nums1.length;
        int n =nums2.length;
        long total1=0;
        long zero1=0;
        long total2=0;
        long zero2=0;

        for(int i=0;i<m;i++){
            if(nums1[i]==0) zero1++;
            else total1+=nums1[i];
        }
        for(int i=0;i<n;i++){
            if(nums2[i]==0) zero2++;
            else total2+=nums2[i];
        }
        long lpx1 = total1+zero1;
        long lpx2 = total2+zero2;
        long required = 0;
        if(lpx1>lpx2){
            required = lpx1-total2;
            if(zero2!=0 && zero2<=required) return lpx1;
        }else if(lpx2>lpx1){
            required=lpx2-total1;
            if(zero1!=0 && zero1<=required) return lpx2;
        }else return lpx1;
        return -1;
    }
}
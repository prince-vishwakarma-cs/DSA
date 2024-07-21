class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ans=0;
        int change=0; // increment
        int num=0;
        for(int i=0;i<nums.length;i++){
            int diff=target[i]-nums[i];
            if(diff>=0){
                if(change==0){
                    if(num<diff){
                        ans+=diff-num;
                        num=diff;
                    } else{
                        num=diff;
                    }
                } else{
                    ans+=diff;
                    change=0;
                    num=diff;
                }
            }else{
                diff=Math.abs(diff);
                if(change==1){
                    if(num<diff){
                        ans+=diff-num;
                        num=diff;
                    } else{
                        num=diff;
                    }
                } else{
                    ans+=diff;
                    change=1;
                    num=diff;
                }
            }
        }
        return ans;
    }
}
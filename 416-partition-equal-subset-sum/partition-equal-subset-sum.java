class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)sum+=i;
        if(sum%2==1) return false;
        sum/=2;
        boolean [][] arr=new boolean [nums.length+1][sum+1];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=true;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                arr[i][j]=(j-nums[i-1]>=0 && arr[i-1][j-nums[i-1]])||arr[i-1][j];
            }
        }
        return arr[nums.length][sum];
    }
}
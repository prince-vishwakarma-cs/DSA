class Solution {
    public int uniqueXorTriplets(int[] nums) {
       int count = 0;
        int n = nums.length;
        boolean[] arr=new boolean[3000];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                arr[nums[i]^nums[j]]=true;
            }
        }
        boolean[] arr2 = new boolean[3000];
        for(int i=0;i<3000;i++){
            for(int j=0;j<nums.length;j++){
                if((nums[j]^i)<3000 && arr[nums[j]^i]) arr2[i]=true;
            }
        }
        for(int i=0;i<3000;i++){
            if(arr2[i]) count++;
        }
        return count;
    }
}
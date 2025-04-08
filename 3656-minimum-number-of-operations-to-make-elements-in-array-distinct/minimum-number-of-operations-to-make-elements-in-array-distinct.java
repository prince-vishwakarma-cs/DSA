class Solution{
 public int minimumOperations(int[] nums){
int n=nums.length;
Set<Integer> set =new HashSet<>();
for(int i=n-1;i>=0;i--){
if(!set.isEmpty() && set.contains(nums[i])){
     int length= (i+1+2)/3;
return length;
   }
set.add(nums[i]);
 }
return 0;
}
}
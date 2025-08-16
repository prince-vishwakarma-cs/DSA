class Solution {
    public int maximum69Number (int num) {
        int i=0;
        String nums = String.valueOf(num);
        int n =nums.length();
        while(i<n && nums.charAt(i)=='9') i++;
        if(i==n) return num;
        int j =i;
        return Integer.parseInt(nums.substring(0,i)+'9'+nums.substring(i+1,n));
    }
}
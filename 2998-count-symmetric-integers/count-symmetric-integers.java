class Solution {
    public boolean isSymmetric(int n){
        String str = String.valueOf(n);
        int l =str.length();
        if(l%2==1) return false;
        int i=0;
        int sum=0;
        while(i<(l/2)){
            sum+=str.charAt(i)-'0';
            i++;
        }
        while(i<l){
            sum-=str.charAt(i)-'0';
            i++;
        }
        return sum==0;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            if(isSymmetric(i)) count++;
        }
        return count;
    }
}
class Solution {
    public boolean isSymmetric(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        if (len % 2 != 0) return false;

        int sum = 0;
        for (int i = 0; i < len / 2; i++) {
            sum += str.charAt(i) - str.charAt(len - 1 - i);
        }

        return sum == 0;
    }
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            if(isSymmetric(i)) count++;
        }
        return count;
    }
}
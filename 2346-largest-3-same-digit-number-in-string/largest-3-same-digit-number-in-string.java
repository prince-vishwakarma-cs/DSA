class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        int n =num.length();
        for(int i=0;i+2<n;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
                if(!ans.equals("")){
            System.out.println(num.substring(i,i+3)); 
                    ans = Integer.parseInt(ans) > Integer.parseInt(num.substring(i,i+3)) ? ans : num.substring(i,i+3);
                }else{
                    ans = num.substring(i,i+3);
                }
            }
        }
        return ans;
    }
}
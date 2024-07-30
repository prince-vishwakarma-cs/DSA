class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] arr=new int[m*n][3];
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k][0]=matrix[i][j];
                arr[k][1]=i;
                arr[k][2]=j;
                k++;
            }
        }
        Arrays.sort(arr,(a,b) -> b[0]-a[0]);
        Integer[][] ans=new Integer[m][n];
        int max=1,p=0,q=0,a1= 0,a2=0,a3= 0,a4=0;
        for(int i=0;i<arr.length;i++){
            p=arr[i][1];
            q=arr[i][2];
            a1=((p-1 >= 0) && matrix[p-1][q]>matrix[p][q]) ? ans[p-1][q] : 0;  //up
            a2=((p+1 < m) && matrix[p+1][q]>matrix[p][q]) ? ans[p+1][q]: 0;  //down
            a3=((q-1 >= 0 ) && matrix[p][q-1]>matrix[p][q]) ? ans[p][q-1]: 0;  //left
            a4=((q+1 < n) && matrix[p][q+1]>matrix[p][q]) ? ans[p][q+1]: 0;  //right
            ans[p][q]=Math.max(Math.max(a1,a2),Math.max(a3,a4))+1;
            max=Math.max(ans[p][q],max);
        }
        return max;
    }
}
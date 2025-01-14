class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] arr=new int[A.length];
        for(int i=0;i<A.length;i++){
            arr[A[i]-1]+=1;
            arr[B[i]-1]+=1;
            if(A[i]==B[i]) A[i]=1;
            else if(arr[A[i]-1]==2 && arr[B[i]-1]==2) A[i]=2;
            else if(arr[A[i]-1]==2 || arr[B[i]-1]==2) A[i]=1;
            else A[i]=0;
            A[i]+=i>0?A[i-1]:0; 
        }
        return A;
    }
}
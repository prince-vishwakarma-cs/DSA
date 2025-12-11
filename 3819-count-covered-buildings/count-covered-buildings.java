class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] topmost=new int[n+1];
        Arrays.fill(topmost,Integer.MAX_VALUE);
        int[] bottommost=new int[n+1];
        int[] leftmost = new int[n+1];
        Arrays.fill(leftmost,Integer.MAX_VALUE);
        int[] rightmost = new int[n+1];
        for(int[] buil:buildings){
            int x =buil[0];
            int y =buil[1];
            int l = leftmost[x];
            int r = rightmost[x];
            int t = topmost[y];
            int b = bottommost[y];
            if(y<l) leftmost[x]=y;
            if(y>r) rightmost[x]=y;
            if(x<t) topmost[y]=x;
            if(x>b) bottommost[y]=x;
        }
        int count=0;
        for(int[] buil:buildings){
            int x =buil[0];
            int y =buil[1];
            int l = leftmost[x];
            int r = rightmost[x];
            int t = topmost[y];
            int b = bottommost[y];
            if(l<y && r>y && t<x && b>x) count++;
        }
        return count;
    }
}
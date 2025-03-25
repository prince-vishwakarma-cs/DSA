class Solution {
    public int ans(int[][] arr){
        List<int[]> lt = new ArrayList<>();
        lt.add(arr[0].clone());

        for (int i = 1; i < arr.length; i++) {
            int[] last = lt.get(lt.size() - 1);

            if (arr[i][0] < last[1]) {
                last[1] = Math.max(last[1], arr[i][1]);
            } else {
                lt.add(arr[i].clone());
            }
        }
        return lt.size();

    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int s=rectangles.length;
        int x[][]=new int[s][2];
        int y[][]=new int[s][2];
        for(int i=0;i<s;i++){
            x[i][0]=rectangles[i][0];
            x[i][1]=rectangles[i][2];
            y[i][0]=rectangles[i][1];
            y[i][1]=rectangles[i][3];
        }
        Arrays.sort(x,(a,b)->(a[0]-b[0]));
        Arrays.sort(y,(a,b)->(a[0]-b[0]));
        if(ans(x)>2 || ans(y)>2) return true;
        else return false;
    }
}
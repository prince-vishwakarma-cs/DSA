class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        int total = 0;
        int neight = 0;
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                total = 0;
                neight=0;
                total += img[i][j];
                neight++;
                if (j > 0) {
                    total += img[i][j - 1];
                    neight++;
                }
                if (j < img[0].length - 1) {
                    total += img[i][j + 1];
                    neight++;
                }
                if (i < img.length - 1) {
                    total += img[i + 1][j];
                    neight++;
                }
                if (i > 0) {
                    total += img[i - 1][j];
                    neight++;
                }
                if (i > 0 && j > 0) {
                    total += img[i - 1][j - 1];
                    neight++;
                }
                if (i > 0 && j < img[0].length - 1) {
                    total += img[i - 1][j + 1];
                    neight++;
                }
                if (i < img.length - 1 && j < img[0].length - 1) {
                    total += img[i + 1][j + 1];
                    neight++;
                }
                if (i < img.length - 1 && j >0) {
                    total += img[i + 1][j - 1];
                    neight++;
                }
                ans[i][j]=total/neight;
            }
        }
        return ans;
    }
}
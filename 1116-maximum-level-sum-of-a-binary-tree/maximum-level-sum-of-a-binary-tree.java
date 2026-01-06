class Solution {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cl = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int current = 0;
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                current+=top.val;
                if(top.left!=null) q.add(top.left);
                if(top.right!=null) q.add(top.right);
            }
            if(current>max){
                level=cl;
                max = current;
            }
            cl++;
        }
        return level;
    }
}
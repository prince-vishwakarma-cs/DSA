class Solution {
    public void inorder(TreeNode root,List<Integer> lt){
        if(root==null) return;
        inorder(root.left,lt);
        lt.add(root.val);
        inorder(root.right,lt);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lt=new ArrayList<>();
        inorder(root,lt);
        return lt;
    }
}
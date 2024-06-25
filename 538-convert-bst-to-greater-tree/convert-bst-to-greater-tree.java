
class Solution {
    public int traverse(TreeNode root,int carry){
        if(root==null) return carry;
        carry=traverse(root.right,carry);
        root.val+=carry;
        carry=root.val;
        return traverse(root.left,carry);
    }
    public TreeNode convertBST(TreeNode root) {
        traverse(root,0);
        return root;
    }
}
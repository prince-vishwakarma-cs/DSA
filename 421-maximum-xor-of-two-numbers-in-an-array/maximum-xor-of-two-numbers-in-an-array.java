class Solution {

    public void insert(int n,TrieNode root){
        TrieNode node =root;
        for(int i=31;i>=0;i--){
            int currBit = (n>>i)&1;
            if(currBit==0){
                if(node.left==null){
                    node.left=new TrieNode();
                }
                node=node.left;
            }else{
                if(node.right==null){
                    node.right=new TrieNode();
                }
                node=node.right;
            }
        }
    }

    public int findmax(int n,TrieNode root){
        TrieNode node = root;
        int max=0;
        for(int i=31;i>=0;i--){
            int ithBit = (n>>i)&1;
            if(ithBit==0){
                if(node.right!=null){
                    max+=1<<i;
                    node=node.right;
                }else node=node.left;
            } else{
                if(node.left!=null){
                    max+=1<<i;
                    node=node.left;
                }else node=node.right;
            }
        }
        return max;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();
        for(int el:nums){
            insert(el,root);
        }
        int max=0;
        for(int el:nums){
            int temp = findmax(el,root);
            max=Math.max(max,temp);
        }
        return max;
    }
}

class TrieNode{
    TrieNode left;
    TrieNode right;
}
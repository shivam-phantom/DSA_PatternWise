/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    int index;
    List<Integer> ar;
    public BSTIterator(TreeNode root) {
        index=0;
        ar = new ArrayList<>();
        inOrder(root);
    }
    
    public int next() {
        // index++;
        return ar.get(index++);
    }
    
    public boolean hasNext() {
        return index<ar.size();
    }

    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        ar.add(root.val);
        // index++;
        inOrder(root.right);
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
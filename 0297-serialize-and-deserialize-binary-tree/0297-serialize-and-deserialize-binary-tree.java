/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    final String EMPTY = "#";
    final String delim = "|";
    int idx =0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> sb = new ArrayList<>();
        dfs(root,sb);
        return String.join(delim,sb);
    }
    public void dfs(TreeNode node, List<String> sb ){
        
        if(node == null){
            sb.add(EMPTY);
            return;
        }
        sb.add(String.valueOf(node.val));
        dfs(node.left,sb);
        dfs(node.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx=0;
        if(data.isEmpty() || data.equals(EMPTY))
            return null;
        List<String> sb = Arrays.asList(data.split("\\|"));
        return deSeril(sb);
    }
    public TreeNode deSeril(List<String> sb){
        if(idx == sb.size())
            return null;
        String val = sb.get(idx++);
        if(val.equals(EMPTY))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deSeril(sb);
        node.right = deSeril(sb);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
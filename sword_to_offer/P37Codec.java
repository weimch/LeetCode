package sword_to_offer;

/**
 * P37Codec
 */
public class P37Codec {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    StringBuilder encode;
    void encodePreorder(TreeNode node){
        if(node == null){
            encode.append("$,");
        }else{
            encode.append(node.val + ",");
            encodePreorder(node.left);
            encodePreorder(node.right);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 使用前序遍历递归编码
        encode = new StringBuilder();
        encodePreorder(root);
        return encode.toString();
    }

    int index;
    TreeNode decodePreorder(String data){
        if(data.charAt(index) == '$'){
            index += 2;
            return null;
        }
        int val_idx = data.indexOf(',', index);
        int val = Integer.parseInt(data.substring(index, val_idx));
        TreeNode node = new TreeNode(val);
        index = val_idx + 1;
        node.left = decodePreorder(data);
        node.right = decodePreorder(data);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 使用前序遍历递归解码
        index = 0;
        return decodePreorder(data);
    }

    public static void main(String[] args) {
        P37Codec sol = new P37Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String enstr = sol.serialize(root);
        sol.deserialize(enstr);
    }
}
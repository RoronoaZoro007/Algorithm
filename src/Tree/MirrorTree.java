package Tree;

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        temp = null;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}

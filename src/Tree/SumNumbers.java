package Tree;

/**
 * 129.求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 例如：
 *      1
 * 2        3
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 */
public class SumNumbers {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("02"));
    }

    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        getResult(root,new StringBuilder());
        return sum;
    }

    public void getResult(TreeNode root,StringBuilder sb){
        if(root.left==null&&root.right==null){
            sb.append(root.val);
            sum+=Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(root.val);
        if(root.left!=null)
            getResult(root.left,sb);
        if(root.right!=null)
            getResult(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}

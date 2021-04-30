package DynamicProgramming;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    /**
     * 95.给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     * 示例：
     * 输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return null;
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode leftNode : leftTrees) {
                for (TreeNode rightNode : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    /**
     * 96.给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * 示例:
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * tip:i个节点可以组成多少个二叉搜索树
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        System.out.println(generateTrees.numTrees(3));
    }

}

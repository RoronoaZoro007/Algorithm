package DynamicProgramming;

import Tree.TreeNode;

public class Rob {

    /**
     * 337 打家劫舍3
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     *
     * 输入: [3,4,5,1,3,null,1]
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     * @param root
     * @return
     */
    public int rob_3(TreeNode root) {
        int[] result=getResult(root);
        return result[0];
    }

    private int[] getResult(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        //pos=0 代表当前这层能取的最大值 pos=1 代表上一层能取的最大值
        int[] left=getResult(root.left);
        int[] right=getResult(root.right);
        //当前这个root的值如果被选中了，最大值为root.val加上左右子树分别的下一层的最大值之和；
        //当前这个root的值如果没被选中，最大值为root的下一层的左右子树的最大值之和
        int chose= root.val+left[1]+right[1];
        int notChose=left[0]+right[0];
        return new int[]{Math.max(chose,notChose),left[0]+right[0]};
    }
}

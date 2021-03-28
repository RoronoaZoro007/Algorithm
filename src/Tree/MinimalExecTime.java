package Tree;

public class MinimalExecTime {

    /**
     * LCP10.二叉树任务调度
     * 任务调度优化是计算机性能优化的关键任务之一。在任务众多时，不同的调度策略可能会得到不同的总体执行时间，
     * 因此寻求一个最优的调度方案是非常有必要的。
     * 通常任务之间是存在依赖关系的，即对于某个任务，你需要先完成他的前导任务（如果非空），才能开始执行该任务。
     * 我们保证任务的依赖关系是一棵二叉树，
     * 其中 root 为根任务，root.left 和 root.right 为他的两个前导任务（可能为空），root.val 为其自身的执行时间。
     * 在一个 CPU 核执行某个任务时，我们可以在任何时刻暂停当前任务的执行，并保留当前执行进度。在下次继续执行该任务时，
     * 会从之前停留的进度开始继续执行。暂停的时间可以不是整数。
     * 现在，系统有两个 CPU 核，即我们可以同时执行两个任务，但是同一个任务不能同时在两个核上执行。
     * 给定这颗任务树，请求出所有任务执行完毕的最小时间。
     * <p>
     * 输入：root = [1,3,2,null,null,4,4]
     * 输出：7.5
     */


    public double minimalExecTime(TreeNode root) {
        return getResult(root)[0];
    }

    /**
     * doubel[0]为最小运行时间 double[1]为串行运行时间
     * @param node
     * @return
     */
    public double[] getResult(TreeNode node) {
        if (node == null)
            return new double[]{0.0, 0.0};
        double[] leftTime = getResult(node.left);
        double[] rightTime = getResult(node.right);
        double minTime = Math.max(leftTime[0], Math.max(rightTime[0], (leftTime[1] + rightTime[1]) / 2));
        return new double[]{minTime + node.val, leftTime[1] + rightTime[1] + node.val};
    }

}

package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1.首先单纯的判断左小于，右大于
 * 2.但是存在同侧左右子树无法判断的情况
 * *     4
 * *    / \
 * *   2   7
 * *      / \
 * * 1   3 6   10
 * <p>
 * 图中2比7小，但是2不大于4
 * 3.设置最大值，最小值概念，对于左子树，root最大值，对于右子树，root小值
 * 4.从图中看，7为当前我们比较的值得根节点，2比它小符合第一条规则，
 * 5.然后我们需要比较当前这颗大的右子树的最小值，看是否比它小，
 * 6.总结两点
 * 1.左子树需要比自己的根节点小，比当前大左子树的根节点小
 * 2.左子树的右子树需要比根节点大，比当前大左子树的根节点小
 * 7.联想：
 * 可以联想它是一个中讯遍历的有序数组，随机一个数需要比自己的左边（自己的根节点）大，右边（自己的根节点）小，还需要比数组最左边（当前大左子树的根节点）的大，最右边的小
 */
public class VerifySearchTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{4, 2, 7, 1, 3, 60, 5});
        System.out.println(new VerifySearchTree().verify(root, null, null));
    }

    private boolean verify(TreeNode<Integer> root, Integer min, Integer max) {
        if(root == null)
            return true;
        Integer v = root.getValue();
        if ((min != null && v <= min) || (max != null && v >= max))
            return false;

        return verify(root.getLeft(), min, root.getValue()) && verify(root.getRight(), root.getValue(), max);
    }

}

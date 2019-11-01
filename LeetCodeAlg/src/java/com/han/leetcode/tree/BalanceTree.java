package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * > 一个二叉树 _每个节点_ 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 `[3,9,20,null,null,15,7]`
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回 `true` 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 `[1,2,2,3,3,null,null,4,4]`
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * <p>
 * 返回 `false` 。
 *
 * 1.在不断向回递归的时候计算差值
 * 2.当一个函数要返还boolean 和 int 时,可以吧-1 看做 false,其他值看做true并且也可以表示int型代表的那个值
 */
public class BalanceTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new BalanceTree().depth(root));
    }

    private int depth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.getLeft());
        int right = depth(root.getRight());

        if ((left == -1 || right == -1) || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right)+1;

    }
}

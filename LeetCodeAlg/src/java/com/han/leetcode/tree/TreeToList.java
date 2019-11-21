package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树， [原地](https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95/8010757) 将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p>
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * 1.找到根节点的左指数的最大值节点
 * 2.连接根节点的右子树的最小值
 * 3.不断推进root
 * 4.将所有值放在一边
 */
public class TreeToList {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1,2,5,3,4,null,6});
        TreeNode<Integer> temp  = root;
        new TreeToList().flattern(temp);

        while (root != null){
            System.out.print(root.getValue()+"  ");
            root = root.getRight();
        }
    }
    private void flattern(TreeNode<Integer> root) {
        while (root != null){
            if(root.getLeft() != null){
                TreeNode<Integer> temp = root.getLeft();
                while (temp.getRight() != null){
                    temp = temp.getRight();
                }

                temp.setRight(root.getRight());
                root.setRight(root.getLeft());
                root.setLeft(null);
            }
            root = root.getRight();
        }

    }
}

package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

import java.util.*;

/**
 * 树的锯齿层次遍历
 */
public class SawToothLevelTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new SawToothLevelTraversal().traversal(root).toString());
    }

    private List<List<Integer>> traversal(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                level.add(node.getValue());
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());

            }

            if(flag){
                Collections.reverse(level);
            }
            flag = !flag;
            result.add(level);
        }
        return result;
    }
}

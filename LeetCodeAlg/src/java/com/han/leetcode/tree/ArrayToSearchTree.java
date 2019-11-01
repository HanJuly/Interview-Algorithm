package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树 _每个节点_ 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ArrayToSearchTree {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9,10,11};
        TreeNode<Integer> root =  new ArrayToSearchTree().build(nums,0,nums.length-1);
        TreeBuilder.lookThrough(root);
    }
    private TreeNode<Integer> build(int[] nums,int start,int end){
        if(start > end)
            return null;
        int mid = (start + end)/2;
        TreeNode<Integer> root = new TreeNode<>(nums[mid]);
        TreeNode<Integer> left = build(nums,start,mid-1);
        TreeNode<Integer> right = build(nums,mid+1,end);
        root.setLeft(left);
        root.setRight(right);
       return root;
    }
}

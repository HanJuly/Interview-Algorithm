package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *    1. 前序遍历会把左子树遍历完，然后遍历右子树
 *    2.中序遍历，的根节点的左右两边节点数代表中序遍历root到左右子树的个数
 *    3.设置 start end的概念，二分法一层一层从下向上
 *    4.左子树可以单纯的用前序下标加一，右子树不能必须通过中序来判断左子树的数量然后用根节点下标相加
 */
public class FrontMiddleBuilderTree {
    public static void main(String[] args) {
        int[] front = {3,9,20,15,7};
        int[] mid = {9,3,15,20,7};
        TreeNode<Integer> root =  new FrontMiddleBuilderTree().builderTree(front,mid);
        TreeBuilder.lookThrough(root);
    }
    private TreeNode<Integer> builderTree(int[] front,int[] mid){
        Map<Integer,Integer> midMap = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            midMap.put(mid[i],i);

        }
        return build(front,0,front.length-1,midMap,0);

    }

    /**
     *fstart   fend   mstart  leftnums  midRoot
     * 0       4       0        1        1
     * 1       1       0        0
     * 2       1
     *
     * 2       4       2        1        3
     * 3       3       2        0        2
     * 4       4       4        0        4
     */
    private TreeNode<Integer> build(int[] front,int fstart,int fend,Map<Integer,Integer> midMap,int mStart){
        if(fstart > fend)
            return null;

        TreeNode<Integer> root = new TreeNode<>(front[fstart]);
        int midRoot = midMap.get(front[fstart]);
        int leftNums = midRoot - mStart;
        System.out.println(String.format("fstart  %s  fend %s  mstart %s leftnums %s midRoot %s",fstart,fend,mStart,leftNums,midRoot));
        TreeNode<Integer> left = build(front,fstart+1,fstart+leftNums,midMap,mStart);
        TreeNode<Integer> right = build(front,fstart+leftNums+1,fend,midMap,midRoot + 1);
        root.setLeft(left);
        root.setRight(right);
        return  root;
    }

}

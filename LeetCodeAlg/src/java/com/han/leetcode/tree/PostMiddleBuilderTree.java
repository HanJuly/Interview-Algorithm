package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    1.思维即是中序和先序的反向即可，
 */
public class PostMiddleBuilderTree {
    public static void main(String[] args) {
        int[] post = {9,15,7,20,3};
        int[] mid = {9,3,15,20,7};
        TreeNode<Integer> root =  new PostMiddleBuilderTree().builderTree(post,mid);
        TreeBuilder.lookThrough(root);
    }
    private TreeNode<Integer> builderTree(int[] post,int[] mid){
        Map<Integer,Integer> midMap = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            midMap.put(mid[i],i);

        }
        return build(post,post.length-1,0,midMap,midMap.size() -1);

    }


    private TreeNode<Integer> build(int[] front,int fend,int fstart,Map<Integer,Integer> midMap,int mEnd){
        if(fstart > fend)
            return null;

        TreeNode<Integer> root = new TreeNode<>(front[fend]);
        int midRoot = midMap.get(front[fend]);
        int rightNums = mEnd - midRoot;
        System.out.println(String.format("fstart  %s  fend %s  mEnd %s rightnums %s midRoot %s",fstart,fend,mEnd,rightNums,midRoot));
        TreeNode<Integer> right = build(front,fend-1,fend-rightNums,midMap,mEnd);
        TreeNode<Integer> left = build(front,fend-rightNums-1,fstart,midMap,midRoot -1);
        root.setLeft(left);
        root.setRight(right);
        return  root;
    }
}

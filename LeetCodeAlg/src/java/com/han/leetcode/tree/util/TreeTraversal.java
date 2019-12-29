package com.han.leetcode.tree.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.han.leetcode.tree.util.TreeBuilder.builder;

/**
 * 1.建立一个双重循环，内层循环不断向左移动
 * 2.走过的点入栈
 * 3.访问左节点的循环完毕开始访问右键点，再进入内层循环访问，直到外层循环栈空为置
 * 4.根据添加元素的位置构造最终的遍历序列
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Integer[] value = {1,2,3,4,5,6,7,null,null,8,null,9,10,null,null};
        TreeNode<Integer> root = builder(value);
        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println("前序遍历：");
        treeTraversal.preTraversal(root);
        System.out.println("\n后序遍历：");
        treeTraversal.afterTraversal(root);
        System.out.println("\n中序遍历：");
        treeTraversal.midTraversal(root);
    }
    public <T> List<TreeNode<T>> preTraversal(TreeNode<T> root){
        List<TreeNode<T>> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        result.add(root);
        while (!stack.isEmpty()){
            TreeNode<T> temp = stack.peek();
            while (temp.getLeft() != null && !result.contains(temp.getLeft())){
                temp = temp.getLeft();
                result.add(temp);
                stack.push(temp);
            }
            if(temp.getRight() != null && !result.contains(temp.getRight())){
                stack.push(temp.getRight());
                result.add(temp.getRight());
            }else {
                stack.pop();
            }

        }

        for (TreeNode<T> tTreeNode : result) {
            System.out.print(String.format("%s -",tTreeNode.getValue()));
        }
        return result;
    }

    public <T> List<TreeNode<T>> afterTraversal(TreeNode<T> root){
        List<TreeNode<T>> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode<T> temp = stack.peek();
            while (temp.getLeft() != null && !result.contains(temp.getLeft())){
                temp = temp.getLeft();
                stack.push(temp);
            }
            if(temp.getRight() != null && !result.contains(temp.getRight())){
                stack.push(temp.getRight());
            }else {
                result.add(stack.pop());
            }

        }

        for (TreeNode<T> tTreeNode : result) {
            System.out.print(String.format("%s -",tTreeNode.getValue()));
        }
        return result;
    }


    public <T> List<TreeNode<T>> midTraversal(TreeNode<T> root){
        List<TreeNode<T>> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){

            TreeNode<T> temp = stack.peek();
            while (temp.getLeft() != null && !result.contains(temp.getLeft())){
                temp = temp.getLeft();
                stack.push(temp);
            }
            if(temp.getRight() != null && !result.contains(temp.getRight())){
                result.add(temp);
                stack.push(temp.getRight());
            }else {
                if(!result.contains(temp))
                    result.add(temp);
                stack.pop();
            }

        }

        for (TreeNode<T> tTreeNode : result) {
            System.out.print(String.format("%s -",tTreeNode.getValue()));
        }
        return result;
    }
}

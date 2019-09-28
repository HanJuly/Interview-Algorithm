package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1.每一个数字都应该是一颗树  for
 * 2.通过root 节点 +1，-1来增加节点，其实是一种前序遍历方式
 * 3.保证一个开始结束规则，start 不能小于 end 以保证不重复
 */
public class DifferentSearchTree {
    public static void main(String[] args) {
        List<TreeNode<Integer>> result =  new DifferentSearchTree().generateTreess(1,3);
        for (TreeNode<Integer> root : result) {
            System.out.println("================================");
            System.out.print(root.getValue()+",");
            TreeBuilder.lookThrough(root);
        }
    }
    private List<TreeNode<Integer>> generateTreess(int start,int end){
        List<TreeNode<Integer>> result = new ArrayList<TreeNode<Integer>>();
        if(start > end){
           result.add(null);
           return result;
        }

        if(start == end){
            result.add(new TreeNode<Integer>(start) );
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode<Integer>> left = generateTreess( start, i -1);
            List<TreeNode<Integer>> right = generateTreess( i+1, end);
            for (TreeNode<Integer> rt : right) {
                for (TreeNode<Integer> lt : left) {
                    TreeNode<Integer> root = new TreeNode<>();
                    root.setValue(i);
                    root.setLeft(lt);
                    root.setRight(rt);
                    result.add(root);
                }
            }
        }
        return result;
    }


}

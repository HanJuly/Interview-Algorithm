package com.han.leetcode.tree;

import java.lang.reflect.Array;

/**
 * 给定一个整数 _n_ ，求以 1 ... _n_ 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释: 给定 _n_ = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * 1.G数组表示当有n个点的时候，有多少种情况
 * 2.一层循环表示以哪点为root
 * 3.二层循环表示左右的情况
 */
public class HowMuchTree {

    public static void main(String[] args) {
        new HowMuchTree().numTrees(4);
    }

    private void numTrees(int n) {
        int[] G = new int[n +1];
        G[0]=G[1] = 1;
        for (int i = 2; i <= n; i++) {
            System.out.println("=====================");
            for (int j = 0; j <i ;j++) {
                G[i] =  G[i] + G[j] * G[i -j-1];
                System.out.println(String.format("G[%s] = G[%s] + G[%s]*G[%s] = %s",i,i,j,i-j-1,G[i]));

            }

        }
    }


}

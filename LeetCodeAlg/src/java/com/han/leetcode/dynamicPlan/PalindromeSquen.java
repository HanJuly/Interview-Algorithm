package com.han.leetcode.dynamicPlan;

/**
 * LeetCode 第 516 题，在一个字符串 S 中求最长的回文子序列。例如给定字符串为 dccac，最长回文就是 ccc。
 *
 * 1.暴力搜索
 * 2.使用前几个这样的语言思维，发现这个问题是需要两边对称的问题，所以不行
 * 3.使用区间规划的思维，从i到j
 * 4.状态转义方程
 *    d[i][j] = d[i+1][j-1] +2    (开头结尾相同)
 *    d[i][j] = Max(d[i][j-1],d[i+1][j])  （开头结尾不相同）
 * 5.程序推进方式，如果用一个一个向上加，这是不对的，这样你的思维还是线性思维
 *   应该使用从一个初始长度的区间，如果数组长度大于这个初始长度就移动这个区间
 *
 * 6.初始值：
 *   d[i][i] = 1
 */
public class PalindromeSquen {
    public static void main(String[] args) {
        int[] nums = {1,6,6,2,5,5,2,6,6,7};
        System.out.println(new PalindromeSquen().maxLength(nums));
    }

    private int maxLength(int[] nums){
        int d[][] = new int[nums.length][nums.length];
        for(int i = 0;i< nums.length ; i++)
            d[i][i] = 1;

        for(int length = 2; length < nums.length+1;length++){
            for(int i = 0 ;i < nums.length-length+1; i++){
                int j = i+length-1;

                if(nums[i] == nums[j] )
                    d[i][j]= length==2 ? 2 :(d[i+1][j-1]+2);
                else
                    d[i][j] = Math.max(d[i][j-1],d[i+1][j]);
            }
        }

        return d[0][nums.length-1];
    }


}

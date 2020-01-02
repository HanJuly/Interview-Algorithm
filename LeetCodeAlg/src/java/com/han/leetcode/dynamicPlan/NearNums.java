package com.han.leetcode.dynamicPlan;

/**
 *LeetCode第 198 题，给定一个数组，不能选择相邻的数，求如何选才能使总数最大。
 *
 * 1.语言影响思维，思维反过来影响语言
 * 关键词： 前多少，递加，抽象函数
 * 动态规划：
 * 线性规划：一定要用前多少个，从0-i，在写状态转移方程的时候将前多少个抽象为函数：如：f(i)，从少到多的递加
 *
 * 这道题，间隔，那么从某一个元素的角度：要么被选，要么不选 0-1 思想
 *
 * 状态转移方程 d[i] = d[i-2] + num[i]  或者  d[i] = d[i-1]
 */
public class NearNums {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,-7,8,9};
        NearNums nearNums = new NearNums();
        System.out.println(nearNums.maxNearNum(nums));

    }

    private int maxNearNum(int[] nums){
        int d[] = new int[nums.length];
        d[0] = nums[0];
        d[1] = Math.max(nums[0],nums[1]);

        int max = 0;
        for(int i =2;i< nums.length; i++){
             d[i] = Math.max(d[i-2] + nums[i],d[i-1]);

             if(max < d[i])
                 max =d[i];
        }

        return max;
    }
}

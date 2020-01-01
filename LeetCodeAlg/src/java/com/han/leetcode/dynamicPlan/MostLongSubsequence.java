package com.han.leetcode.dynamicPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.求最长的字串
 *
 * 1.暴力求出所有的组合
 * 2.尝试分割
 * 3.一个一个叠加，发现有重复计算的子结构
 * 4.递归方式一层层向上计算结果
 * 5.使用数组+循环，d[n]={0,n-1}的最大字结构
 *
 * 状态转移方程： f(n)=Max(f(i)+1{0<i<n-1, num[i-1]< num[n-1]})
 */
public class MostLongSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 4};
        MostLongSubsequence alg = new MostLongSubsequence();
//        alg.mostLong(nums, nums.length);
        alg.mostLong(nums);
        System.out.println(alg.max);

    }

    private static int max = 1;
    private static Map<Integer, Integer> cache = new HashMap<>();

    private int mostLong(int[] nums, int n) {
        if (cache.containsKey(n))
            return cache.get(n);

        if (n == 1)
            return 1;
        int maxEnd = 1;
        for (int i = 1; i < n; i++) {
            int result = mostLong(nums, i);
            if (nums[i - 1] < nums[n - 1] && result + 1 > maxEnd)
                maxEnd = result + 1;

        }

        if (max < maxEnd)
            max = maxEnd;
        cache.put(n, maxEnd);
        return maxEnd;
    }

    private void mostLong(int[] nums) {
        int[] d = new int[nums.length];
        for (int i = 0; i < d.length; i++)
            d[i] = 1;


        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] < nums[i - 1] && d[j] + 1 > d[i])
                    d[i] = d[j] + 1;
            }
            max = Math.max(max, d[i]);
        }

    }
}

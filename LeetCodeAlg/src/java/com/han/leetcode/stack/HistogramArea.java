package com.han.leetcode.stack;

import java.util.Stack;

/**
 * LeetCode 第 84 题：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 1.当栈空时，宽度应该是游标i
 */
public class HistogramArea {
    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        int max = new HistogramArea().maxArea(nums);
        System.out.println(String.format("最大值：%s",max));
    }

    private int maxArea(int[] nums){
        int maxAera = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=nums.length;i++){
            while (!stack.isEmpty() && (i== nums.length||nums[i] < nums[stack.peek()])){
                int height = nums[stack.pop()];
                int width = stack.isEmpty()?i:i-1-stack.peek();
                maxAera = Math.max(maxAera,height*width);
            }
            stack.push(i);
        }

        return maxAera;
    }
}

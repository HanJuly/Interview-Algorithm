package com.han.leetcode.sort;

import java.util.Arrays;

/**
 * 1.相邻的元素相互比较
 * 2.第一层循环控制比较的轮数，边界值要是length-1，防止比较过程中j+1越界
 * 3.第二层j-i控制比较的元素，防止排好序的被移动,其实不会移动，减少比较次数
 * 4.判断如果没有了变化就表示拍好了，不必继续
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums ={2,4,8,6,3,7,4,1,0};
            boolean isHasChange = true;
        for(int i = 0;i< nums.length-1&& isHasChange;i++){
            isHasChange=false;
            for(int j =0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                    isHasChange=true;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void  swap(int[] nums,int l, int h){
        int temp = nums[l];
        nums[l]=nums[h];
        nums[h]=temp;
    }
}

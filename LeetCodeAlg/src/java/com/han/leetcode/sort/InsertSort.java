package com.han.leetcode.sort;

import java.util.Arrays;

/**
 * 1.第二层循环逆向比较，j=i-1避免自己比较自己
 * 2.for中游两个条件表示一旦遇到不符合条件的就停止，因为前面的序列已经排列好
 * 3.这种用一个数去一直比较或者插入的逻辑，先把基准值保存，然后交换最后再去处理基准值
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums ={2,1,8};
        for (int i = 1; i < nums.length; i++) { //2
            int current = nums[i];
            int j = i-1;
            //两个条件表示一旦遇到不符合条件的就停止，因为前面的序列已经排列好
            //如果将条件写入for循环中，当遇到没满足条件的数字，j值一直在移动导致交换赋值最后一步的时候赋值错误位置
            for(;j>=0 && current < nums[j];j--){
                   nums[j+1] = nums[j];
            }

            nums[j+1]=current;

        }
        System.out.println(Arrays.toString(nums));
    }

    private static void  swap(int[] nums,int l, int h){
        int temp = nums[l];
        nums[l]=nums[h];
        nums[h]=temp;
    }
}

package com.han.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 1.首先单独处理子集
 * 2.使用子集的基准值作为mid
 * 3.排序方式：交换并移动来表示插入
 * 4.先排序再拆分
 * 5.假设基准值最后存入l的位置
 * 6.这里涉及到三个数的，基准值在中间，所以交换两边值然后最后处理基准值
 * 7.然而插入排序是涉及两个交换，可以保存基准值再去处理
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1,2,4,1,0,8,2,3,6,9};
        QuickSort quickSort= new QuickSort();
        quickSort.split(nums,0,nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    private void split(int[] nums,int l,int h){
        if(l >= h){
            return;
        }
        int baseIndex = sort(nums,l,h);
        split(nums,l,baseIndex-1);
        split(nums,baseIndex+1,h);
    }
    private int sort(int[] nums,int l,int h){


        int baseIndex =(int) (Math.random()*(h-l+1)+l);
        swap(nums,baseIndex,h);

        int i=l,j=l;
        for (;j< h; j++) {
            if(nums[j] < nums[h])
               swap(nums,i++,j);

        }

        swap(nums,i,h);
        return i;

    }

    private void swap(int[] nums,int l, int h){
        int temp = nums[l];
        nums[l]=nums[h];
        nums[h]=temp;
    }
}

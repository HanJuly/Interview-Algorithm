package com.han.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1,2,4,1,0,8,2,3,6,9};
        QuickSort quickSort= new QuickSort();
        quickSort.split(nums,0,nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    private void split(int[] nums,int l,int h){
        if(l <= h){
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

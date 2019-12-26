package com.han.leetcode.sort;

import java.util.Arrays;

/**
 * 1.先拆分再排序，自下而上
 * 2.快排的中间数是独立的不参与排序
 * 3.归并的没有中间数概念
 * 4.先比较拷贝，再拷贝剩余，但是写代码的时候要反过来写，否则会出现越界
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2,1,4,5,8,4,3,6,1,5,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.split(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private void split(int[] nums,int left,int right){
        if(left >= right)
            return;
        int mid = left+(right-left)/2; // 0
        split(nums,left,mid); // 0,0
        split(nums,mid+1,right); //1,1
        merge(nums,left,mid,right);// 0,0,1
    }
    private void merge(int[] nums,int left,int mid,int right){

        int[] copy =nums.clone();

        int k = left;  //0,1
        int i = left;  //0
        int j = mid+1;  //1,2

        while(k<=right){
            //回收剩余数组的数据一定要再比较的前面，否则会出现数组越界
            if(i>mid){
                nums[k++]=copy[j++];
            }else if(j >right){
                nums[k++]=copy[i++];
            }else if(copy[i] >copy[j]){
                nums[k++]=copy[i++];
            }else if(copy[i] <= copy[j]){
                nums[k++]=copy[j++];
            }
        }



    }
}

package com.han.leetcode.binarySearch;

/**
 * 首先一定先在排序好的那边判断是否在哪个范围内，不在然后再到另一半去
 * 否则错误，所以首要的任务是判断那边是排好序的
 */
public class SearchRotateArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;


        int pos=new SearchRotateArray().search(nums,target);

        System.out.println("Target pos is:"+pos);

    }

    private int search(int[] nums, int target) {
        int low = 0;
        int height = nums.length-1;
        while(low <= height){
            int middle = low + (height-low)/2;
            if(nums[middle] == target)
                return middle;

            //如果是降序的数组，nums[low] > nums[middle]
            if(nums[low] < nums[middle]){
                //左边是排序好的
                if(nums[low]<target && target< nums[middle]){
                    height=middle-1;
                }else {
                    low=middle+1;
                }
            }else {
                //右边是排序好的
                if(nums[middle]<target && target< nums[height]){
                    low=middle+1;
                }else {
                    height=middle-1;
                }
            }

        }
        return -1;
    }

}

package com.han.leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 第 04 题：给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m+n))。
 你可以假设 nums1 和 nums2 不会同时为空。

 示例1
 nums1 = [1, 3]
 nums2 = [2]
 则中位数是 2.0

 示例2
 nums1 = [1, 2]
 nums2 = [3, 4]
 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 *使用快排思想，O(n)
 *
 * 1.求下标一定要用起始位置+你算出来的随机值
 * 2.分布式的时候通过缩小基准值来代替缩小范围
 *
 */
public class MedianQuickMethod {
    public static void main(String[] args) {
            int[] nums = {1,3,5,7,9,11,13,15};//1,3,5,7,9,15,13,11
            //15,3,5,7,9,1,13,11
            //15,13,11,7,9,1,3,5
            System.out.println(new MedianQuickMethod().findMedian(nums));
    }

    private double findMedian(int[] nums){
        int k = nums.length/2;
        if((nums.length)%2 == 0){
            double k1= quick(nums,0,nums.length-1,k);
            double k2= quick(nums,0,nums.length-1,k);
            return (k1+k2)/2f;

        }else {
          return   quick(nums,0,nums.length-1,k+1);
        }
    }

    private double quick(int[] nums,int low,int he,int k){
       int pivot = (int) (Math.random()*(he-low+1)+low);
//       int pivot = low;
       swap(nums,pivot,he);
       int finishPos = low;
        System.out.println("p:"+nums[he]);
       for(int i=low;i<nums.length;i++){
          if(nums[i]>nums[he]){
              swap(nums,i,finishPos);
              finishPos++;
          }
       }
       swap(nums,he,finishPos);
        System.out.println(Arrays.toString(nums));

       //第几个
       int tempk = finishPos-low+1;
        System.out.println("第k大："+tempk + "要求：" + k);
       if(tempk==k)
           return nums[finishPos];
       else if(tempk<k)
           return quick(nums,finishPos+1,he,k-tempk);
       else
           return quick(nums,low,finishPos-1,k);
    }


    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

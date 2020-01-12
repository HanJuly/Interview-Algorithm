package com.han.leetcode.array;

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
 *
 * 1.暴力法
 * 2.切分法--- 缩小范围，折半寻找
 *     1.数组总和是奇数还是偶数
 *     2.某一个数组为零的或者将短数组放在前面减少搜索时间
 *     3.如果总和是奇数， （m+n）/2 +1  偶数  两个数的平均值  （m+n）/2 +1  （m+n）/2 +2
 *
 *  注意：
 *     一些特殊值可以提前处理，不要继续进入逻辑
 *     一些细微上+1 -1的操作，如果可以多一个变量来避免，代码更容易理解
 *
 */
public class MedianSegmentMethod {
    public static void main(String[] args) {
            int[] num1 = {};
            int[] num2 = {1};
            System.out.println(new MedianSegmentMethod().findMedian(num1,num2));
    }

    private double findMedian(int[] num1,int[] num2){
        int k = (num1.length+num2.length)/2;
        if((num1.length+num2.length)%2 == 0){
            return (find(num1,0,num1.length-1,num2,0,num2.length-1,k)+
                    find(num1,0,num1.length-1,num2,0,num2.length-1,k+1))/2.0f;

        }else {
          return   find(num1,0,num1.length-1,num2,0,num2.length-1,k+1);
        }
    }

    private double find(int[] num1,int low1,int he1,int[] num2,int low2,int he2,int k){
        int m = he1-low1+1;
        int n = he2-low2+1;

        int va = Math.min(m,k/2);
        int vb = k -va;
        int base1=low1+va-1;
        int base2=low2+vb-1;

        if(m>n){
            find(num2, low2, he2, num1, low1, he1,k);
        }

        if(m==0){
            return num2[low1+k-1];
        }

        if (k == 1) {
            return Math.min(num1[low1], num2[low2]);
        }

        if(num1[base1]== num2[base2]){
            return num1[base1];
        }else if(num1[base1]< num2[base2]){
           return find(num1,base1+1,he1,num2,low2,base2,k-va);
        }else {
           return find(num1,low1,base1,num2,base2+1,he2,k-vb);
        }
    }
}

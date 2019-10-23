package com.han.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    /**
     * [1,2,4,5,6,0]
     * 5
     * [3]
     * 1
     * @param args
     */
    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2 = {3};
        new MergeSort().merge(num1,0,num2,num2.length);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m ==0 && n == 0)
            return;
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < nums2.length) {

            if(nums1[i] < nums2[j]){
                res.add(nums1[i]);
                i++;
            }else {
                res.add(nums2[j]);
                j++;
            }

        }

        if(i < m){
            while (i < m){
                res.add(nums1[i]);
                i++;
            }
        }

        if(j < nums2.length){
            while (j < nums2.length){
                res.add(nums2[j]);
                j++;
            }
        }
        for (int k = 0; k < nums1.length; k++) {
            nums1[k] = res.get(k);

        }
        System.out.println(Arrays.toString(nums1));
    }
}

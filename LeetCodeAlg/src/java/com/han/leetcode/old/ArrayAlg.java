package com.han.alg;

import java.util.*;

public class ArrayAlg {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        ArrayAlg arrayAlg = new ArrayAlg();
        System.out.println(Arrays.toString(arrayAlg.intersect(nums1, nums2)));
    }

    /**
     * 数组去除连续重复
     */
    private int removeDuplicates(int[] nums) {
        int lastIndex = nums.length;

        for (int i = 0; i < lastIndex - 1; ) {

            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                lastIndex--;
            } else {
                i++;
            }

        }

        System.out.println(Arrays.toString(nums));
        System.out.println(String.format("新数组的长度是%s", lastIndex));
        for (int i = 0; i < lastIndex; i++) {
            System.out.println(nums[i]);
        }

        return lastIndex;
    }

    /**
     * 股票收益最大化
     */
    public int stockMax() {
        int prices[] = {3, 3};
        int newLength = removeDuplicates(prices);
        if (newLength <= 1) {
            return 0;
        }
        int totalProfit = 0;
        List<Integer> keyPoints = new ArrayList<Integer>();
        keyPoints.add(prices[0]);
        for (int i = 1; i < newLength; i++) {
            if (prices[i] > prices[i - 1] && (i == newLength - 1 || prices[i] > prices[i + 1])) {
                keyPoints.add(prices[i]);
            }

            if (prices[i] < prices[i - 1] && (i == newLength - 1 || prices[i] < prices[i + 1])) {
                keyPoints.add(prices[i]);
            }

        }

        System.out.println("==========================================");
        keyPoints.forEach(x -> System.out.println(x));
        int index = 0;
        if (keyPoints.get(0) > keyPoints.get(1)) {
            index = 1;
        }
        for (; index < keyPoints.size() - 1; index += 2) {

            totalProfit += keyPoints.get(index + 1) - keyPoints.get(index);
        }
        System.out.println("最大收益：" + totalProfit);
        return totalProfit;
    }

    private int rolateArray(int[] nums, int k) {
        int lastIndex = nums.length;

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }


        System.out.println(Arrays.toString(nums));
        return lastIndex;
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!temp.add(nums[i])) {
                return true;
            }

        }

        return false;
    }

    /**
     * 利用异或相同为0，相异为1
     * 前提是两个重复数据
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp ^ nums[i];

        }
        return temp;
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    res.add(nums1[i]);
                    nums2[j] = Integer.MAX_VALUE;
                    break;
                }
            }

        }



        
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);

        }
        return result;

    }
}


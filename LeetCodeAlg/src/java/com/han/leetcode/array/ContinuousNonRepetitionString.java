package com.han.leetcode.array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 连续不重复字串
 * LeetCode 第 03 题：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1
 *输入："abcabcbb"
 *输出：3
 *解释：因为无重复字符的最长子串是"abc"，其长度为3。

 *示例 2
 *输入："bbbbb"
 *输出：1
 *解释：因为无重复字符的最长子串是 "b"，其长度为 1。
 *
 *
 * 思路：
 *    1.数组，链表，连续  ---> 线性法， 一个一个元素递加， 快慢指针
 *    2.在一个数组中找一段连续不重复的区间  --》 快慢指针相减+1
 *    3.数组的下标查找要使用hash
 */
public class ContinuousNonRepetitionString {
    public static void main(String[] args) {
        String[] data = {"d","e","a","d","c","a","q"};
        System.out.println(new ContinuousNonRepetitionString().length(data));
        System.out.println(new ContinuousNonRepetitionString().lengthStep(data));
    }

    /**
     * 使用Map快速跳转慢指针的方法
     * @param nums
     * @return
     */
    private int length(String[] nums){
        int i = 0;
        int j = 0;
        Map<String,Integer> temp = new HashMap<>();
        int max = 0;
        for(;j<nums.length;j++){
            if(temp.containsKey(nums[j])){
                i = temp.get(nums[j])+1;
            }
            temp.put(nums[j],j);
            max=Math.max(max,j-i+1);
        }
        return max;
    }


    /**
     * 使用循环删除的方式，更新慢指针
     * @param nums
     * @return
     */
    private int lengthStep(String[] nums){
        int i = 0;
        int j = 0;
        Set<String> temp = new HashSet<>();
        int max = 0;
        for(;j<nums.length;j++){
            while (temp.contains(nums[j])){
                temp.remove(nums[i]);
                i++;
            }
            temp.add(nums[j]);
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}

package com.han.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 340 题：给定一个字符串 s ，找出至多包含 k 个不同字符的最长子串 T。
 *
 * 示例 1
 * 输入: s = "eceba", k = 2
 * 输出: 3

 * 解释: 则 T 为 "ece"，所以长度为 3。

 * 示例 2
 * 输入: s = "aa", k = 1
 * 输出: 2

 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * 1.有两个游标不要去变量计算了
 */
public class MaxDifferentSubchar {
    public static void main(String[] args) {
        String s = "e";
        int k = 2;
        Map<Character,Integer> temp = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int tempLength = 0;
        for(;j<s.length();j++){

            Character x = s.charAt(j);
            temp.put(x,temp.getOrDefault(x,0)+1);

            if(temp.size() > k){
                Character c = s.charAt(i);
                maxLength = Math.max(maxLength,tempLength);
                tempLength--;


               temp.put(c,temp.getOrDefault(c,0)-1);
                if(temp.get(c) == 0)
                    temp.remove(c);


                i++;

            }
            tempLength++;


        }
        maxLength = Math.max(maxLength,tempLength);
        System.out.println("MaxLength: "+maxLength);
    }
}

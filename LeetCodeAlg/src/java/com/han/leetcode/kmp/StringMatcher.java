package com.han.leetcode.kmp;

/**
 * LeetCode 第 28 题：
 * 实现 strStr() 函数。给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从 0 开始)
 * 。如果不存在，则返回 -1。
 * <p>
 * 示例 1
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 解释："ll"出现在 haystack 第 2 个位置。
 */
public class StringMatcher {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "hello";

        System.out.println(new StringMatcher().indexof(haystack,needle));

    }

    private int indexof(String s, String m) {
        for (int i = 0; i < s.length()-m.length()+1; i++) {
            int t = i;
            for (int j = 0; j < m.length(); j++) {
                if (s.charAt(t) != m.charAt(j))
                    break;
                t++;
            }
            int matchLength = t==i?-1: t-i;
            if(matchLength == m.length())
                return i;
        }

        return -1;
    }
}

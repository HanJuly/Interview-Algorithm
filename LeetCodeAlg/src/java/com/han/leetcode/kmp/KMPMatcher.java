package com.han.leetcode.kmp;

import java.util.Arrays;

/**
 * 首先要找到公共前后缀
 * 使用前后指针，如果不相同以后有指针，相同两个一起移动
 * 同时左指针来记录长度为len的字串长度
 * <p>
 * 表示j之前的下一个前后缀的长度，比如连续相等的情况就可以向后退一步来继续比较
 * 这是有指针需要继续不动
 *
 * 通过上面lps数组进行跳跃
 * 如果j移动过，表示lps数组有值可以进行跳跃否则只能继续比较开头
 */
public class KMPMatcher {
    public static void main(String[] args) {
        String haystack = "ABAxAB";
        int[] ps = new KMPMatcher().prixSuffix(haystack);
        int index = new KMPMatcher().indexof(haystack, "ABH", ps);
        System.out.println(Arrays.toString(ps));
        System.out.println("位置："+index);
    }

    private int indexof(String s, String m, int[] ps) {
        if(m.length() == 0)
            return  0;

        int j = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == m.charAt(j)) {
                j++;
                i++;
            } else if(j > 0){//如果j移动过，表示lps数组有值可以进行跳跃否则只能继续比较开头
                j = ps[j-1];
            }else {
                i++;
            }
            if (j == m.length())
                return i - m.length();

        }

        return  -1;
    }

    private int[] prixSuffix(String s) {
        int len = 0;
        int[] ps = new int[s.length()];
        ps[0] = 0;
        ps[1] = 0;
        int j = 1;
        while (j < s.length()) {
            if (s.charAt(len) == s.charAt(j)) {
                ps[j++] = ++len;
            } else if (len > 0) {
                //表示j之前的下一个前后缀的长度，比如连续相等的情况就可以向后退一步来继续比较
                len = ps[len - 1];
            } else {
                j++;
            }

        }

        return ps;
    }
}

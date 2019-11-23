package com.han.leetcode.array;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 1.首先放弃查找的方式
 * 2.使用hash方式
 * 3.
 */
public class CharDifferentPostion {
    String s = "anagrx", t = "nagara";
    int[] flags = new int[26];

    public static void main(String[] args) {
        System.out.println(new CharDifferentPostion().isSame());
    }

    public boolean isSame() {
        if (s.length() != t.length())
            return false;
        if (s.length() == 0 && t.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            flags[s.charAt(i) - 'a'] += 1;
            flags[t.charAt(i) - 'a'] -= 1;
        }

        for (int flag : flags) {
            if (flag == 1)
                return false;
        }
        return true;
    }
}

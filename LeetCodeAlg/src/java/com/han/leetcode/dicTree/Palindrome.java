package com.han.leetcode.dicTree;

import com.han.leetcode.tree.util.TreeTraversal;

import java.util.*;

/**
 * LeetCode  第 336 题，回文对：给定一组唯一的单词，
 * 找出所有不同的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * 示例 1
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * <p>
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * <p>
 * <p>
 * <p>
 * 示例 2
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * <p>
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 *
 * 1.使用字典树结构存放所有字符串的逆序
 *   1.每添加一个节点需要判断当前节点之前（因为是逆序构造）的节点是否是回文对
 *   2.需要判断当前节点是否是一个结束节点
 *
 * 2.使用字典树搜索
 *    1.搜索的key >=  字段树中的节点
 *    2.搜索key < 字典树的字符串
 *
 * 3.自己与自己不能成对
 */
public class Palindrome {

    public static void main(String[] args) {
        String s[] = {"abac","a","caba","bcba"};
        TreeNode root = new Palindrome().builderTree(s);

        List<Integer[]> result = new Palindrome().search(s, root);
        for (Integer[] integers : result) {
            System.out.println(Arrays.toString(integers));
        }
    }

    private  List<Integer[]> search(String[] input, TreeNode root) {
        List<Integer[]> pairs = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            pairs.addAll(search(s,root,i));
        }
        return pairs;
    }

    private List<Integer[]> search(String input, TreeNode root, int index) {
        List<Integer[]> pairs = new ArrayList<>();
        TreeNode r = root;
        int i = 0;
        while (r != null && i < input.length()) {
            r = r.children.get(input.charAt(i));

            if(r == null)
                return pairs;

            System.out.println(String.format("char: %s  i %s index %s  r %s",input.charAt(i),i,index,r));
            if (r.index > -1 && isPalindrome(input, i + 1, input.length() - 1) && r.index != index) {
                Integer[] p = new Integer[2];
                p[0] = index;
                p[1] = r.index;
                pairs.add(p);
                return pairs;
            }
            i++;

        }

        if (i == input.length() && r != null && r.palindromes.size() != 0) {
            System.out.println("==");
            for (int pos : r.palindromes) {
                if(pos == index)
                    continue;
                Integer[] p = new Integer[2];
                p[0] = index;
                p[1] = pos;
                pairs.add(p);
            }

        }
        return pairs;
    }

    private TreeNode builderTree(String[] input) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < input.length; i++) {
            builder(input[i], root, i);
        }

        return root;
    }

    private void builder(String input, TreeNode root, int index) {
        //遍历完后，不会出现root == null
        for (int i = input.length() - 1; i > -1; i--) {
            Character c = input.charAt(i);
            if (!root.children.containsKey(c))
                root.children.put(c, new TreeNode());

            if (isPalindrome(input, 0, i-1))
                root.children.get(c).palindromes.add(index);

            root = root.children.get(c);

        }

        root.index = index;
        root.palindromes.add(index);
    }


    private boolean isPalindrome(String s, int start, int end) {
        if (start == end)
            return false;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    class TreeNode {
        int index = -1; //当前叶子节点是哪一个字符串的结束点
        Map<Character, TreeNode> children = new HashMap<>(); //子节点的
        Set<Integer> palindromes = new HashSet<>(); //从头开始到当前的那些单词是回文对
    }
}

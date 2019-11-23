package com.han.leetcode.array;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/group-anagrams
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiffrentCharGroup {


    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String,List<String>> res = new HashMap<>();
        for (String s : arr) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String st = new String(temp);
            if(res.containsKey(st))
                res.get(st).add(s);
            else{
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                res.put(st,tempList);
            }
        }


        for (List<String> strings : res.values()) {
            System.out.println(Arrays.toString(strings.toArray()));
        }
    }
}

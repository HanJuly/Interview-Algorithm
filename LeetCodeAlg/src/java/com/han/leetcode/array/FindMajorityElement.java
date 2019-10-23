package com.han.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class FindMajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int res = new FindMajorityElement().majorityElement(nums);
        System.out.println(res);

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> statictis = new HashMap<>();
        for (int num : nums) {
            if (!statictis.containsKey(num))
                statictis.put(num, 1);
            else
                statictis.put(num, statictis.get(num) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : statictis.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }

        return -1;
    }
}

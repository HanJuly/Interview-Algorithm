package com.han.leetcode.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 异或运算，相同为0，相异为1
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,2,3,1,8};
        System.out.println(new SingleNumber().singleNumber(a));
    }

    public int singleNumber(int[] nums) {

        for (int i = 1;i< nums.length;i++) {
            nums[0] = nums[0] ^ nums[i];
        }

        return nums[0];
    }
}

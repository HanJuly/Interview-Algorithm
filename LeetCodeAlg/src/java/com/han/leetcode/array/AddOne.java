package com.han.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class AddOne {
    public static void main(String[] args) {
        int nums[] = new int[]{9, 1, 2};
        System.out.println(Arrays.toString(new AddOne().plusOne(nums)));
    }

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        if (digits[digits.length - 1] > 9)
            digits = isopsephy(digits, digits.length - 1);
        return digits;
    }


    private int[] isopsephy(int[] digits, int index) {
        if (index == 0) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);

            newArray[1] = newArray[1] % 10;
            newArray[0] = 1;

            return newArray;
        }
        digits[index] = digits[index] % 10;
        digits[index - 1] = digits[index - 1] + 1;
        if (digits[index - 1] > 9) {
            digits = isopsephy(digits, index - 1);
        }

        return digits;
    }
}

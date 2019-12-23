package com.han.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/daily-temperatures
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 1.关键点在，栈的存储的是小标而不是值，每向前一步，就操作一遍stack
 */
public class EverdayTemp {

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new int[8];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temp.length; i++) {

            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]){
                    result[stack.peek()]=(i-stack.pop());
            }
            stack.push(i);

        }

        System.out.println(Arrays.toString(result));
    }
}

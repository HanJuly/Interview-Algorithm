package com.han.leetcode.quene;

import java.util.*;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  -3  3] -3  -1 3  1  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1.优先队列 nlogn ,而且解决不了元素重复的问题，除非用hash
 * 2.双端队列  在插入的过程中比较大小，由于在双端队列的两端查询，插入都是O（1）,
 *   所以将总的复杂度降低到了o(n)，如果单向队列，复杂度就升级为n^2
 *
 */
public class SlideWindow {


    public static void main(String[] args) {
         twoHeaderQuene();
    }

    public static void priQueneMethod(){
        int k = 3;
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>((x,y) -> (y-x));
        int[] temp = {1,3,-1,-3,5,3,6,7};
        int[] result = new int[temp.length-k+1];
        for (int i = 0; i < temp.length; i++) {
            if(i < k){
                priorityQueue.offer(temp[i]);
                if(i==k-1)
                    result[i-k+1]=priorityQueue.peek();
            }else {
                priorityQueue.remove(temp[i-k]);
                priorityQueue.offer(temp[i]);
                result[i-k+1]=priorityQueue.peek();
            }
        }

        System.out.println(Arrays.toString(result));
    }

    public static void  twoHeaderQuene(){
        int k = 3;
        Deque<Integer> deque = new LinkedList<>();
        int[] temp = {1,3,-1,-3,5,3,6,7};
        int[] result = new int[temp.length-k+1];
        deque.offer(0);
        for (int i = 1; i < temp.length; i++) {

            if(temp[deque.peekFirst()] < temp[i]){
                deque.clear();
                deque.offerFirst(i);
            }else {
                deque.offer(i);
            }


            if(i>k-2){
                result[i-k+1]=temp[deque.peekFirst()];
            }

        }
        System.out.println(Arrays.toString(result));
    }


}



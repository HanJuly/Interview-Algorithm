package com.han.leetcode.quene;

import java.util.*;

/**
 *给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

    示例 1:

    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:

    输入: nums = [1], k = 1
    输出: [1]
    说明：

    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/top-k-frequent-elements
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  1.暴力搜索法的 n+kn
 *  2.优先队列 n+nlogk
 *
 *  根据复杂度分析，方法对于小 k 的情况是很优的。但是如果 k 值很大，我们可以将算法改成删除频率最低的若干个元素。
 *
 */
public class KHighFrequencyElements {
    public static void main(String[] args) {
        int k = 2;
        int[] target = {1,3,2,2,2,3};
        int[] result = new int[k];
        Map<Integer,Integer> temp = new HashMap<>();
        for (int i : target) {
            temp.put(i,temp.getOrDefault(i,0)+1);
        }

        Queue<Integer> queue = new PriorityQueue<Integer>((n1,n2)->(temp.get(n2)-temp.get(n1)));
        for (int i : temp.keySet()){
            queue.offer(i);
        }

        int n = 0;
        while (!queue.isEmpty() && n<k){
            result[n]=queue.poll();
            n++;
        }

        System.out.println(Arrays.toString(result));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

}

package com.han.leetcode.interval;

import java.util.Arrays;

/**
 * LeetCode 第 435 题：给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 示例 1
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 示例 2
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 示例 3
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 1.暴力法
 *   按起始时间排序
 *   利用前后指针，当前进行删除或者不删除继续向下递归走然后统计删除个数
 *   利用递归return结果+1
 *   交叉就只能删除，不交叉就需要删除或者不删除
 *   为什么要删除或者不删除呢？
 *   【0,9】【1,2】【3,5】，如果一味判断交叉就删除后面一个，那么最后区间数是1，其实应该是2
 *   删除的对象？
 *     删除的事当前区间，开始时要将-1，0加入，否则就少了删除第一个元素的情况。比如上面就无法求出
 *
 * 2.贪心
 *   按照时间开始排序
 *   尽可能的去删除区间长度长的，因为他与其他区间交叉的概率更高
 *
 *  3.按时间结束排序
 *      最多有多少个不交叉的区间，反向思考这个问题
 *      按照结束时间排序
 */
public class LeastRemoveInternal {
    public static void main(String[] args) {
//       int[][] internals ={{0,3},{1,2},{5,9},{4,10}};
       int[][] internals ={{0,9},{1,2},{3,5}};

        System.out.println(new LeastRemoveInternal().removeIntervals(-1,0,internals));
        System.out.println(new LeastRemoveInternal().removeIntervals(internals));
        System.out.println(new LeastRemoveInternal().removeIntervals2(internals));
    }



    /**
     * 暴力法
     * @param pre
     * @param current
     * @param internals
     * @return
     */
    private int removeIntervals(int pre,int current,int[][] internals){
        Arrays.sort(internals,(a, b)->(a[0]-b[0]));
        //边界值一定要是小标+1，否则会漏掉最后两个数的比较直接在这里返回了
        if(current==internals.length)
            return 0;
        int remove1 = Integer.MAX_VALUE;
        int remove2 = Integer.MAX_VALUE;
        if(pre==-1 || internals[current][0] >= internals[pre][1]){
            remove1= removeIntervals(current,current+1,internals);
        }

        remove2 =removeIntervals(pre,current+1,internals)+1;
        remove2 =Math.min(remove1,remove2);
       return  remove2;
    }

    /**
     * 贪心
     * @param internals
     * @return
     */
    private int removeIntervals(int[][] internals){
        Arrays.sort(internals,(a, b)->(a[0]-b[0]));
        int end = -1;
        int count =0;
        for(int i= 0 ;i < internals.length;i++){
            if(end != -1 && internals[i][0]<end){
                count++;
                end=Math.min(internals[i][1],end);
            }else
                end=internals[i][1];
        }

        return count;
    }

    /**
     * 最多有多少个不交叉的区间，反向思考这个问题
     * 按照结束时间排序
     */
    private int removeIntervals2(int[][] internals){
        Arrays.sort(internals,(a, b)->(a[1]-b[1]));
        int end =internals[0][1];
        int count =0;
        for(int i= 1 ;i < internals.length;i++){
            if(internals[i][0] > end) {
                count++;
                end = internals[i][1];
            }

        }

        return count;
    }
}

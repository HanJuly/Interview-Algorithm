package com.han.leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 56 题：给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 *
 * 示例 1
 *
 * 输入: [[1,3], [2,6], [8,10], [15,18]]
 *
 * 输出: [[1,6], [8,10], [15,18]]
 *
 *
 *
 * 解释: 区间 [1,3] 和 [2,6] 重叠，将它们合并为 [1,6]。
 *
 *
 *
 * 示例 2
 *
 * 输入: [[1,4], [4,5]]
 *
 * 输出: [[1,5]]
 *
 *
 *
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 1.区间问题：
 *    1.按起始时间或者结束时间排序
 *    2.判断下一个起点和上一个区间结束点大小关系
 *    3.前后指针
 */
public class MergeInternal {
    public static void main(String[] args) {
        Integer[][] internal = {{1,3},{2,6},{8,10},{9,18}};
        List<Integer[]> result = new MergeInternal().getResult(internal);
        for (Integer[] integers : result) {
            System.out.print(Arrays.toString(integers)+"==>");
        }
    }

    private List<Integer[]> getResult(Integer[][] internals){
        Arrays.sort(internals,(a,b)->(a[0]-b[0]));
        int pre=-1;
        List<Integer[]> result = new ArrayList<>();
        for(int current=0;current< internals.length;current++){
            if(pre==-1 || internals[current][0]>internals[pre][1]){
                pre=current;
                result.add(internals[current]);
            }else {
                //不需要添加，最终都是会被上一个分支加入，如果在这里加入还有重复的问题
                //不需要判断最后一个元素并加入结果，因为前一个一定会被先加入结果，只需要更新就好，即是回溯到第一个
                internals[pre][1]=Math.max(internals[current][1],internals[pre][1]);
            }
        }

        return result;
    }
}

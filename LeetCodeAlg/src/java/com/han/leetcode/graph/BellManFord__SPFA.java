package com.han.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 思想： 广度优先
 * 1.队列+ 循环
 * 2.每次将与当前定点相连的点入队列
 * 3.并与最短路径数组比较并更新 (即传说中松弛操作)
 * 4.使用数组标记是否在队列中，防止走回头路（这个感觉上是不需要的，但是写上微妙）
 * 5.让元素可以重复入队是为了同一个点有多个环的情况
 * 6.如果这个点重复入环的次数超过点数，那么就一定出现负数环，因为n个点最多出现n-1个环
 */
public class BellManFord__SPFA {
    public static void main(String[] args) {
        /*
                  1                 4
           0                3                 5
                   2
         */
        int[][] graph = {{0, 1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {1, 0, Integer.MAX_VALUE, 2, 2, Integer.MAX_VALUE},
                {1, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 2, 1, 0, Integer.MAX_VALUE, 5},
                {Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 1, 0}};

        // 负环图
//        int[][] graph = {{0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE,Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, -5, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,0, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};

        int startIndex = 0;
        //是否在队列中
        int isInQuene[] = new int[graph.length];
        int vsCount[] = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);

        int[] minDis = new int[graph.length]; //0,1,1,MAX,MAX,MAX
        int[] preNode = new int[graph.length];//0,0,0,0,0,0
        for (int i = 1; i < graph.length; i++) {
            minDis[i] = Integer.MAX_VALUE;
        }


        vsCount[0]++;
        while (!queue.isEmpty()) {
            Integer index = queue.poll();// 0
            isInQuene[index] = 0;
            for (int i = 0; i < graph.length; i++) {
                if (graph[index][i] != Integer.MAX_VALUE && graph[index][i] != 0) {
                    int dis = graph[index][i] + minDis[index];
                    if (dis < minDis[i]) {
                        minDis[i] = dis;
                        preNode[i] = index;
                        if (isInQuene[i] == 0){
                            queue.offer(i);
                            isInQuene[i]=-1;
                            if(++vsCount[i] > graph.length-1){
                                System.out.println("Graph has a negative circle .It makes no sense ");
                                return;
                            }
                        }
                    }

//                    graph[index][i] = Integer.MAX_VALUE;
//                    graph[i][index] = Integer.MAX_VALUE;
                }

            }
        }

        System.out.println("最小路径:" + Arrays.toString(minDis));
        System.out.println("前驱数组:" + Arrays.toString(preNode));
    }
}

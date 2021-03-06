package com.han.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 思想： 广度优先+贪心
 * 1.队列+ 循环
 * 2.每次将与当前定点相连的点入队列
 * 3.队列是优先队列，下一次循环选出从源点到当前点最短的路径的点重复操作，并将这个点标记为找到最短路径，防止重复入队
 * 4.由于不需求重复入队，当一个点有两条路径的入度的时候，一条路径是1，另一条路径是1+（-5）
 *   那么这个点被优先队列选择出了第一条后，当第二次走第二条路径过来时，就无法重新更新这个点后面的值了
 * 5.如果是无向图，还会导致前驱数组的结果错误
 * 6.它也bell-man区别在于，前者是针对点，后者是针对边，虽然看上去代码差不多
 *   前者无法解决有负数权重的图，后者可以
 * 7.当出现负数环的时候，前者不会一直循环下去，因为它不允许重复入队，
 *   后者允许重复入队所以导致会一直循环，所以需要排队每个点入队的次数，次数超多n就说明有环
 *   而地杰斯特拉是不知道有没有环的
 */
public class dijkstra {
    public static void main(String[] args) {
        /*
                  1                 4
           0                3                 5
                   2
         */
//        int[][] graph = {{0, 1, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {1, 0, Integer.MAX_VALUE, 2, 2, Integer.MAX_VALUE},
//                {2, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, 2, 1, 0, Integer.MAX_VALUE, 5},
//                {Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 1, 0}};

        // 负环图
//        int[][] graph = {{0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE,Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, -5, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,0, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};

        int[][] graph={{0,5,3},
                       {5,0,-4},
                        {3,-4,0}};

        int startIndex = 0;
        //是否在队列中
        int isInQuene[] = new int[graph.length];
        int[] minDis = new int[graph.length]; //0,1,1,MAX,MAX,MAX
        boolean[] flag = new boolean[graph.length]; //0,1,1,MAX,MAX,MAX
        Queue<Integer> queue = new PriorityQueue<>((n1,n2) ->(minDis[n1] - minDis[n2]));
        queue.offer(startIndex);

        int[] preNode = new int[graph.length];//0,0,0,0,0,0
        for (int i = 1; i < graph.length; i++) {
            minDis[i] = Integer.MAX_VALUE;
        }


        while (!queue.isEmpty()) {
            Integer index = queue.poll();// 0
            if(flag[index]){
                continue;
            }
            flag[index] = true;

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

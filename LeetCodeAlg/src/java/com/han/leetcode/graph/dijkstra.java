package com.han.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class dijkstra {
    public static void main(String[] args) {
        int[][] graph ={{0, 1, 1, Integer.MAX_VALUE, 2,  Integer.MAX_VALUE},
                {1, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE},
                {2, Integer.MAX_VALUE, Integer.MAX_VALUE,  Integer.MAX_VALUE, 0, 1},
                {Integer.MAX_VALUE,  Integer.MAX_VALUE,  Integer.MAX_VALUE, 1,  1, 0}};

        int startIndex = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);

        int[] minDis = new int[graph.length]; //0,1,1,MAX,MAX,MAX
        int[] preNode = new int[graph.length];//0,0,0,0,0,0
        for(int i = 1; i<graph.length;i++)
            minDis[i]=Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            Integer index = queue.poll();  // 0
            for (int i = 0;i < graph.length;i++){
                if(graph[index][i] != Integer.MAX_VALUE && graph[index][i] != 0){
                    int dis = graph[index][i]+minDis[index];
                    if(dis < minDis[i]){
                        minDis[i]=dis;
                        preNode[i]=index;
                    }
                    if(queue.contains(i))
                        queue.offer(i);
                    graph[index][i] =Integer.MAX_VALUE;
                    graph[i][index] = Integer.MAX_VALUE;
                }

            }
        }

        System.out.println("最小路径:"+Arrays.toString(minDis));
        System.out.println("前驱数组:"+Arrays.toString(preNode));
    }
}

package com.han.leetcode.graph;

import java.util.*;

public class BreadthFirst {
    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        int[][] graph ={{Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE,  Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, -1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, -1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, -1, -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE,  Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE,  Integer.MAX_VALUE,  Integer.MAX_VALUE, Integer.MAX_VALUE,  Integer.MAX_VALUE, -1}};
        int[] S = {0,2};
        int[] E = {4,2};
        BreadthFirst depthFirst = new BreadthFirst();
        depthFirst.method(graph,S,E);

    }



    private  void method(int[][] graph, int[] S, int[] E){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{S[0],S[1]});
        graph[S[0]][S[1]]=0;
        step(graph,E,queue);

       printGraph(graph);

    }


    /**
     * 1.每走一步就标记
     * 2.使用队列，每一步都要遍历完每一步产生的队列元素
     * 3.Inter,Max 查看记录步数的深度优先
     * 4.一定要在选择方向的时候进行判断是否到终点，以减少标记次数，也更能体现广度与深度的区别
     * 5.虽然与记录步数的深度优先很像，都是标记步数，但是这里是在广度的标记步数，到终点时能保证它是最短的路径
     * 6.然而深度标记的方式是找到终点时是不能确定它是最短的，需要继续找其他的路
     * @param graph
     * @param E
     * @param queue
     */
    private void step(int[][] graph, int[] E,  Queue<Integer[]> queue){
        while (!queue.isEmpty()){
            Integer[] point = queue.poll();
            int x = point[0];
            int y = point[1];



            for(int i=0;i<4;i++){
                int tx = x+dx[i];   //-1,1,0
                int ty = y+dy[i];   //2,2,3


                if(isSafe(graph,tx,ty) && graph[tx][ty] > graph[x][y] +1){
                    graph[tx][ty] = graph[x][y] +1;
                    if(tx == E[0] && ty==E[1]){
                        return;
                    }
                    Integer[] temp = {tx,ty};
                    queue.offer(temp);


                }
            }

        }
    }

    private boolean isSafe(int[][] graph,int x, int y){
        if(x<0 || x>graph[0].length-1 || y<0 || y>graph.length-1)
            return false;

        if(graph[x][y] == -1)
            return false;

        return true;
    }

    private void printGraph(int[][] graph) {
        for(int i = 0;i< graph.length;i++){
            for(int j=0;j<graph[0].length;j++)
                System.out.print(String.format("%s                      |",graph[i][j]));
            System.out.println("");
        }
    }
}

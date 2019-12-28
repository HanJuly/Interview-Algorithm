package com.han.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1.标记每一步步数
 * 2.不管是递归还是栈的方式都不能去判断是否到达终点，否则就只能有一条路被标记
 * 3.将所有的可走的点标记为最大值是一个技巧，即能过防止走回头路，有可以在两条路的交叉位置赋值更小的步数
 */
public class DepthFirstRecHasStep {
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
        DepthFirstRecHasStep depthFirstRecHasStep = new DepthFirstRecHasStep();
        depthFirstRecHasStep.method1(graph,S,E);
    }

    public   void method1(int[][] graph, int[] S, int[] E){
        //标记这是第一步
        graph[S[0]][S[1]] = 0;
        step(graph,S[0],S[1],E);

        printGraph(graph);



    }


    private void step(int[][] graph, int x, int y,int[] E){

        for(int i=0;i<4;i++){
            int tx = x+dx[i];   //-1,1,0
            int ty = y+dy[i];   //2,2,3


            if(isSafe(graph,tx,ty) && graph[tx][ty] > graph[x][y]+1){
                graph[tx][ty] = graph[x][y]+1;
                step(graph,tx,ty,E);

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

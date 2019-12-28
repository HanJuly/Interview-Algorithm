package com.han.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstHasStep {
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

//        DepthFirstRec depthFirstRec = new DepthFirstRec();
//        depthFirstRec.method1(graph,S,E);

        DepthFirstHasStep depthFirst = new DepthFirstHasStep();
        depthFirst.method2(graph,S,E);

    }



    private  void method2(int[][] graph, int[] S, int[] E){
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{S[0],S[1]});
        graph[S[0]][S[1]]=0;
        step(graph,E,stack);
        printGraph(graph);

    }



    /**
     * 1.使用栈记录未来需要走的路
     * 2.每次pop以后标记-1
     * 3.加一个标志判断是否无路可走，然后取出route末尾值
     * 4.如果判断安全后就标记为-1，那么当出现无路可走时，会出现多记录一个错误方向的坐标，其实它已经退了两步了
     * 5.初始节点加入栈后，立即标记为-1
     * @param graph
     * @param E
     * @param stack
     */
    private void step(int[][] graph, int[] E, Stack<Integer[]> stack){
        while (!stack.isEmpty()){
            Integer[] point = stack.pop();

            int x = point[0];
            int y = point[1];


            for(int i=0;i<4;i++){
                int tx = x+dx[i];   //-1,1,0
                int ty = y+dy[i];   //2,2,3


                if(isSafe(graph,tx,ty) && graph[tx][ty] > graph[x][y]+1){
                    graph[tx][ty] = graph[x][y]+1;
                    Integer[] temp = {tx,ty};
                    stack.push(temp);

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

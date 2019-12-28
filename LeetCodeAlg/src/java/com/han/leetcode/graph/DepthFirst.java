package com.han.leetcode.graph;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirst {
    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        int[][] graph ={{0, 0, 0, 0, 0,  0},
                        {0, 0, -1, 0, 0, 0},
                        {0, 0, -1, 0, 0, 0},
                        {0, 0, -1, -1, 0, 0},
                        {0, -1, 0,  0, 0, 0},
                        {0,  0,  0, 0,  0, -1}};
        int[] S = {0,2};
        int[] E = {4,2};

        DepthFirst depthFirst = new DepthFirst();
//        depthFirst.method1(graph,S,E);
        depthFirst.method2(graph,S,E);

    }

    /**
     * 递归深度优先
     * 1.递归就不要用栈
     * 2.倒叙记录点
     * 3.一旦判断点安全就要标记点，否则会出现回头路
     * 4.
     * @param graph
     * @param S
     * @param E
     */
    private  void method1(int[][] graph, int[] S, int[] E){
          List<Integer[]> route = new ArrayList<>();
          step(graph,S[0],S[1],E,route);
          Collections.reverse(route);

          for(Integer[] r:route){
              System.out.print(String.format("[%s,%s] ==>",r[0],r[1]));
          }


    }

    private  void method2(int[][] graph, int[] S, int[] E){
        List<Integer[]> route = new ArrayList<>();
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{S[0],S[1]});
        graph[S[0]][S[1]]=-1;
        step(graph,E,route,stack);
        for(Integer[] r:route){
            System.out.print(String.format("[%s,%s] ==>",r[0],r[1]));
        }


    }

    private boolean step(int[][] graph, int x, int y,int[] E, List<Integer[]> route){
        if(x == E[0] && y==E[1]){
            return true;
        }

        for(int i=0;i<4;i++){
           int tx = x+dx[i];   //-1,1,0
           int ty = y+dy[i];   //2,2,3


            if(isSafe(graph,tx,ty) ){
                graph[tx][ty] = -1;
                if( step(graph,tx,ty,E,route)){
                    Integer[] r = {tx,ty};
                    route.add(r);
                    return true;
                }

            }
        }

        return false;
    }

    /**
     * 1.使用栈记录未来需要走的路
     * 2.每次pop以后标记-1
     * 3.加一个标志判断是否无路可走，然后取出route末尾值
     * 4.如果判断安全后就标记为-1，那么当出现无路可走时，会出现多记录一个错误方向的坐标，其实它已经退了两步了
     * 5.初始节点加入栈后，立即标记为-1
     * @param graph
     * @param E
     * @param route
     * @param stack
     */
    private void step(int[][] graph, int[] E, List<Integer[]> route, Stack<Integer[]> stack){
        while (!stack.isEmpty()){
            Integer[] point = stack.pop();
            graph[point[0]][point[1]] = -1;
            route.add(point);
            int x = point[0];
            int y = point[1];

            if(x == E[0] && y==E[1]){
                return;
            }

            boolean allNotSafe = true;
            for(int i=0;i<4;i++){
                int tx = x+dx[i];   //-1,1,0
                int ty = y+dy[i];   //2,2,3


                if(isSafe(graph,tx,ty) ){

                    Integer[] temp = {tx,ty};
                    stack.push(temp);
                    allNotSafe=false;

                }
            }

            if(allNotSafe){
                route.remove(route.size()-1);
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

}

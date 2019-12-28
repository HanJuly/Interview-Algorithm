package com.han.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepthFirstRec {
    private int[] dx = {1,-1,0,0};
    private int[] dy = {0,0,1,-1};
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
    public   void method1(int[][] graph, int[] S, int[] E){
        List<Integer[]> route = new ArrayList<>();
        //标记这是第一步
        step(graph,S[0],S[1],E,route);
        Collections.reverse(route);

        for(Integer[] r:route){
            System.out.print(String.format("[%s,%s] ==>",r[0],r[1]));
        }
        System.out.println();




    }


    private boolean step(int[][] graph, int x, int y,int[] E, List<Integer[]> route){
        if(x == E[0] && y==E[1]){
            return true;
        }

        for(int i=0;i<4;i++){
            int tx = x+dx[i];   //-1,1,0
            int ty = y+dy[i];   //2,2,3


            if(isSafe(graph,tx,ty) && graph[tx][ty] > graph[x][y]+1){
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

    private boolean isSafe(int[][] graph,int x, int y){
        if(x<0 || x>graph[0].length-1 || y<0 || y>graph.length-1)
            return false;

        if(graph[x][y] == -1)
            return false;

        return true;
    }
}

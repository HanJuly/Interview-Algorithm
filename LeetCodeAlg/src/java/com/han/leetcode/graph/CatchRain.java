package com.han.leetcode.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 第 407 题：给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 说明：m 和 n 都是小于 110 的整数。每一个单位的高度都大于 0 且小于 20000。
 *
 * 示例：
 * 给出如下 3x6 的高度图:
 *
 * [
 *
 * [1,4,3,1,3,2],
 *
 * [3,2,1,3,2,4],
 *
 * [2,3,3,2,3,1]
 *
 * ]
 *
 *
 * 返回 4。
 *
 * 1.从外围选出最低的高度，然后向中间收缩
 * 2.更新当前节点周围的最高点给最新的点
 * 3.每向优先队列中加入一个点就重新选出最小点
 * 4.斜方向是不会漏水的
 */
public class CatchRain {
    public static void main(String[] args) {
        int[][] pool ={ {1,4,3,1,3,2},
                        {3,2,1,3,2,4},
                        {2,3,3,2,3,1}};
        boolean visit[][] = new boolean[pool.length][pool[0].length];
        PriorityQueue<Cell> queue = new CatchRain().builderPriorityQueue(pool,visit);
        int bulk = new CatchRain().catchRain(pool,queue,visit);
        System.out.println("接水体积： "+ bulk);


    }

    private int catchRain(int[][] pool,PriorityQueue<Cell> queue,boolean visit[][]){
        int[][] steps = {{0,-1},{0,1},{-1,0},{1,0}};

        int bulk = 0;
        while (!queue.isEmpty()){
            Cell t = queue.poll();
            System.out.println(String.format("row %s |colume %s |外围最小：%s ",t.row,t.colum, t.height));


            for(int i =0;i< steps.length;i++){
                int row = t.row+steps[i][0];
                int colum = t.colum+steps[i][1];
                //如果每一个方向都走不了，从其他的方向去尝试
                if(row < pool.length&& row > 0 &&colum>0 &&colum < pool[0].length && !visit[row][colum]){
                    System.out.println(String.format("row %s column %s",row,colum));
                    bulk+=Math.max(0,t.height-pool[row][colum]);
                    int height = Math.max(pool[row][colum],t.height);
                    queue.offer(new Cell(row,colum,height));
                    visit[row][colum] = true;
                }
            }
        }

        return bulk;
    }

    private PriorityQueue<Cell> builderPriorityQueue(int[][] pool,boolean visit[][]){
        PriorityQueue<Cell> queue = new PriorityQueue<>((a,b) ->(a.height - b.height));
        for(int i=0;i< pool[0].length;i++){
            queue.offer(new Cell(0,i,pool[0][i]));
            visit[0][i] = true;

            queue.offer(new Cell(pool.length-1,i,pool[pool.length-1][i]));
            visit[pool.length-1][i] = true;
        }


        for(int i=0;i< pool.length;i++){
            queue.offer(new Cell(i,0,pool[i][0]));
            visit[i][0] = true;

            queue.offer(new Cell(i,pool[0].length-1,pool[i][pool[0].length-1]));
            visit[i][pool[0].length-1] = true;
        }


        return queue;

    }

    class Cell{
        int row = -1;
        int colum = -1;
        int height = -1;

        public Cell(int row, int colum, int height) {
            this.row = row;
            this.colum = colum;
            this.height = height;
        }
    }

}

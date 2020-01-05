package com.han.leetcode.dynamicPlan;

import java.util.Arrays;

/**
 * 1.如果单纯的使用线性规划和区间规划去做都存在排列组合情况考虑不全的问题
 * 2.感觉也不是所有的动态规划都可以使用排列组合去反证
 * 3.递推方程：
 * 一个个的加入背包中
 * W(i) <= j         V(i,j) = Max(V(i-1,j),V(i-1,j-W(i))+V(i))
 * W(i) > j         V(i,j) = V(i-1,j)
 * <p>
 * 表示这个物体是否选中
 * x =1    V(i,j) >= V(i-1,j-W{i})+V(i)
 * x =0    V(i,j) = V(i-1,j)   j  = j -W(i)
 *
 *
 *   int w[] = {0, 2, 3, 4, 5};            //商品的体积2、3、4、5
    int v[] = {0, 3, 4, 5, 6};            //商品的价值3、4、5、6
    int bagV = 8;
 *
 *      0   1  2  3  4  5  6  7  8
 *
    0  [0, 0, 0, 0, 0, 0, 0, 0, 0]
    1  [0, 0, 0, 0, 0, 0, 0, 0, 0]
    2  [0, 0, 3, 3, 3, 3, 3, 3, 3]
    3  [0, 0, 3, 4, 4, 7, 7, 7, 7]
    4  [0, 0, 3, 4, 5, 7, 8, 9, 9]
    5  [0, 0, 3, 4, 5, 7, 8, 9, 10]

    总体：
      1.当这个物体放入包里时，如果只放入它一个可以放下
          1.加上这个物体的前几个，放不下   就取 v[i-1][j]
          2.加上前几个物体可以放下， 就取 v[i-1][j - w[i-1]] + V[i-1]
          3.取两者最大值
      2.如果这个物体单独存放都放不下就取  v[i-1][j]

   细节：
      1.求Max时 将 v[i][j]  放到前面 value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - w[i-1]] + v[i-1]);

 */
public class ZeroOrOneBag {
    public static void main(String[] args) {
        int w[] = {0, 2, 3, 4, 5};            //商品的体积2、3、4、5
        int v[] = {0, 3, 4, 5, 6};            //商品的价值3、4、5、6
        int bagV = 8;
        // 前 n 个元素放入承重j的背包
        int[][] value = new int[w.length+1][bagV+1];
        int[] isChoose = new int[w.length];
        for (int i = 0; i < value.length; i++) {
            value[i][0] = 0;
            value[0][i] = 0;
        }

        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < bagV+1; j++) {
                if (w[i - 1] <= j) {
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - w[i-1]] + v[i-1]);
                } else {
                    value[i][j] = value[i - 1][j];
                }
            }
        }


        for (int i = 0; i < value.length; i++)
            System.out.println(Arrays.toString(value[i]));

        int i = 5;
        int j = bagV;
        while (true){
            if(i == 0)
                break;
            if(value[i][j] == value[i-1][j]){

                isChoose[i-1] = 0;
                i = i-1;
            }
            else {
                isChoose[i-1] = 1;
                j = j- w[i-1];
                i = i-1;
            }


        }

        System.out.println("选取数据："+ Arrays.toString(isChoose));
    }
}

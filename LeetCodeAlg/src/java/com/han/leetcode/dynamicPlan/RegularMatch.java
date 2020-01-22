package com.han.leetcode.dynamicPlan;

import java.util.Arrays;

/**
 * 正则匹配
 * 1.切分
 *   有两个数组，一个匹配的字符串，一个正则字符串
 *   使用二维数组表示两个数组长度为n,m时是否匹配
 * 2.状态转移方程
 *   if(j != *)    d[i][j]=d[i-1][j-1] && isMatch(a[i],b[j])
 *   if(j == *)    d[i][j]=d[i][j-2] || (d[i-1][j-2] && isMatch(a[i][j-1]))
 */
public class RegularMatch {
    public static void main(String[] args) {
//      String s = "aaa";
//      String p = ".*";

      String s = "aaaa";
      String p = "a.*a";
        System.out.println(new RegularMatch().isMatch(s,p));
    }

    private boolean isMatch(String  s ,String p){
        boolean[][] d = new boolean[s.length()+1][p.length()+1];
        d[0][0] = true;
        for (int i=1;i<s.length()+1;i++)
            d[i][0]=false;

        for (int j=1;j<p.length()+1;j++)
            d[0][j]=j>1 && d[0][j-2] &&p.charAt(j-1)=='*';

        for (int i=1;i<s.length()+1;i++){
            for (int j=1;j<p.length()+1;j++){
                if(p.charAt(j-1) != '*'){
                    d[i][j] = d[i-1][j-1] && isMatch(s.charAt(i-1),p.charAt(j-1));
                }else {
                    d[i][j] = d[i][j-2] || d[i-1][j] && isMatch(s.charAt(i-1),p.charAt(j-2));
                }
            }

        }

        for (boolean[] v : d)
            System.out.println(Arrays.toString(v));

        return d[s.length()][p.length()];

    }

    private boolean isMatch(char a,char b){
        if(a == b || b == '.'){
            return true;
        }

        return false;
    }
}

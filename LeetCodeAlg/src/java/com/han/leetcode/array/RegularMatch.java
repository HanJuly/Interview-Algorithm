package com.han.leetcode.array;

/**
 * 正则匹配点和星号
 *
 * 1.下一个不为*
 * 2.下一个为*,当前相等
 * 3.下一个为*,当前不相等
 * 4.注意越界问题
 */
public class RegularMatch {

    public static void main(String[] args) {
        String s = "abbba";
        String m = "a.*";
        System.out.println(new RegularMatch().isMatch(s,0,m,0));
    }


    private boolean isMatch(String s,int i,String m,int j){
        //不能使用m-l
        if(j==m.length())
            return i == s.length();

        //防止越界
        if(j == m.length()-1 ||  m.charAt(j+1) != '*' ){
            //  i<s.length() 防止越界
            return  i<s.length() && isMatch(s.charAt(i),m.charAt(j)) && isMatch(s,i+1,m,j+1);
        }

        //防止越界
        if(j< m.length()-1 && m.charAt(j+1) == '*'){
            while(i< s.length() && isMatch(s.charAt(i),m.charAt(j))){

            if(isMatch(s,i,m,j+2))
                return true;
            i++;
            }
        }

        //下一个是星号，但是当前字符不相等，把这个*视为0
        return isMatch(s,i,m,j+2);
    }
    private boolean isMatch(char a,char b){
        if(a == b || b == '.'){
            return true;
        }

        return false;
    }
}

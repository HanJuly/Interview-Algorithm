package com.han.leetcode.array;

/**
 * 正则匹配点和星号 反向匹配
 *
 * 1.前一个不为*
 * 2.前一个为*,当前相等
 * 3.字符走完，正则未能走完,正则只能是全是".*" 或者"a*"
 * 4.注意越界问题
 *
 *
 * 1.正则匹配使用快慢指针，所以结束条件应该是去使用快慢指针是否同时结束
 * 2.正向与反向的匹配其实一样的，正向的匹配如果写为循环的效率会高一些，写为反向的抵消法其实是一样的
 * 3.逻辑与 优先级高于逻辑或
 * 4.如果多个条件只要有一个不满足就要结束遍历，使用return ,如果多个条件不满足，但还有其他情况可走使用if
 * 5.当s到-1时特殊处理，否则会一直做抵消操作,
 //  如果没有判断i =-1情况，"bb" ,"d.*" 会导致一直在抵消操作，但是"bb",".*"这种情况就会在j=-1的时候，i 刚好等于-1
 //  如果是正向比较这种情况就不会产生，当比较第一个的时候就被终止了
 * */
public class RegularMatch2 {

    public static void main(String[] args) {
        String s = "bb";
        String m = "d.*";
        System.out.println(new RegularMatch2().isMatch(s,s.length()-1,m,m.length()-1));
    }


    private boolean isMatch(String s,int i,String m,int j){
        if(j==-1)
            return i == -1;

//        //当s到-1时特殊处理，否则会一直做抵消操作,
         //如果没有判断i =-1情况，"bb" ,"d.*" 会导致一直在抵消操作，但是"bb",".*"这种情况就会在j=-1的时候，i 刚好等于-1
         //如果是正向比较这种情况就不会产生，当比较第一个的时候就被终止了
        if(i==-1){
            return j > 0 && m.charAt(j) == '*'&& isMatch(s,i,m,j-2);
        }

        //防止越界
        if( m.charAt(j) != '*' ){
            //  i<s.length() 防止越界
            return  i>-1 && isMatch(s.charAt(i),m.charAt(j)) && isMatch(s,i-1,m,j-1);
        }

        return isMatch(s,i,m,j-2) || isMatch(s,i-1,m,j) && isMatch(s.charAt(i),m.charAt(j-1));



    }
    private boolean isMatch(char a,char b){
        if(a == b || b == '.'){
            return true;
        }

        return false;
    }
}

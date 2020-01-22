package com.han.leetcode.test;

import com.han.leetcode.linkList.KElementsTransfer;
import com.han.leetcode.linkList.util.LinkListUitl;
import org.junit.Test;


import static com.han.leetcode.linkList.util.LinkListUitl.builder;

public class SomeTest {
    public static void main(String[] args) {
        Integer[] test = new Integer[]{1,2,3,4,5};
        LinkListUitl.Node<Integer> head = LinkListUitl.builder(test);
        LinkListUitl.printLinkList(head);

         head = KElementsTransfer.transfer(head,3);
        System.out.println("==========");
        System.out.println();
        LinkListUitl.printLinkList(head);


    }

    @Test
    public void testMather(){
        String s = "abbba";
        String m = "a.*";
        System.out.println(isMatch(s,s.length(),m,m.length()));
    }

    boolean isMatch(String s, int i, String p, int j) {
        if (j == 0) return i == 0;
        if (i == 0) {
            log("i==0",s,i,p,j);
            return j > 1 && p.charAt(j - 1) == '*' && isMatch(s, i, p, j - 2);
        }

        if (p.charAt(j - 1) != '*') {
            log("p.charAt(j - 1) != '*'",s,i,p,j);
            return isMatch(s.charAt(i - 1), p.charAt(j - 1)) &&
                    isMatch(s, i - 1, p, j - 1);
        }

        log("other",s,i,p,j);
        return  isMatch(s, i, p, j - 2) || isMatch(s, i - 1, p, j) &&
                isMatch(s.charAt(i - 1), p.charAt(j - 2));
    }

    boolean isMatch(char a, char b) {
        return a == b || b == '.';
    }


    private void log(String pos,String s, int i, String p, int j){

        System.out.println("================================================");
        System.out.println(String.format("%s : s i %s,m j %s",pos,i,j));
        System.out.println(String.format("%s : s char %s,m char %s",pos,s.charAt(i-1),p.charAt(j-1)));
        System.out.println("================================================\n");
    }
}

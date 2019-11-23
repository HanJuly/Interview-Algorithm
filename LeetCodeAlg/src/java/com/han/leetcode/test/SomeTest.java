package com.han.leetcode.test;

import com.han.leetcode.linkList.KElementsTransfer;
import com.han.leetcode.linkList.util.LinkListUitl;


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
}

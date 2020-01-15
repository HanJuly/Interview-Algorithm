package com.han.leetcode.linkList.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 第 23 题：合并 k 个排好序的链表，返回合并后的排序链表。分析和描述算法的复杂度。
*
*
 *示例
*
 *输入：
*
 *[
*
 *1 -> 4 -> 5,
*
 *1 -> 3 -> 4,
*
 *2 -> 6
*
 *]
*
*
*
 *输出：1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
 *
 * 1.最小堆法处理表头
 * 2.归并处理表头
 *
 *
 */
public class MergeLinkList {
    public static void main(String[] args) {
        Integer[] nums1={1,3,5,7,9,11,13,15,17};
        Integer[] nums2={2,4,6,8,10,12,14};
        LinkListUitl.Node<Integer> root1 = LinkListUitl.builder(nums1);
        LinkListUitl.Node<Integer> root2 = LinkListUitl.builder(nums2);
        LinkListUitl.Node<Integer>[] heads =new LinkListUitl.Node[2];
        heads[0] = root1;
        heads[1] = root2;

        LinkListUitl.Node<Integer> result = new MergeLinkList().method1(heads);
        LinkListUitl.printLinkList(result);

        LinkListUitl.Node<Integer> result1=new MergeLinkList().method2(heads,0,heads.length-1);
        LinkListUitl.printLinkList(result1);
    }

    /**
     * 最小堆
     * @param heads
     * @return
     */
    public  LinkListUitl.Node<Integer> method1 (LinkListUitl.Node<Integer>[] heads){
        LinkListUitl.Node<Integer> result = new LinkListUitl.Node<>(-1);
        LinkListUitl.Node<Integer> head = result;
        PriorityQueue<LinkListUitl.Node<Integer>> priorityQueue =
                new PriorityQueue<LinkListUitl.Node<Integer>>((m,n)->(m.value-n.value));

        for(int i=0;i< heads.length;i++)
            priorityQueue.offer(heads[i]);

        while(!priorityQueue.isEmpty()){
            LinkListUitl.Node<Integer> min = priorityQueue.poll();
            result.value=min.value;
            result.next=new LinkListUitl.Node<>(-1);
            result=result.next;

            if(min.next!=null)
                priorityQueue.offer(min.next);
        }

        return head;

    }

    /**
     * 归并分之思想
     * @param heads
     * @param low
     * @param he
     * @return
     */
    public  LinkListUitl.Node<Integer> method2 (LinkListUitl.Node<Integer>[] heads,int low,int he){
        if(low>=he)
            return heads[low];

        int middle = low+(he-low)/2;

       return merge(method2(heads,low,middle),method2(heads,middle+1,he));


    }

    private LinkListUitl.Node<Integer> merge(LinkListUitl.Node<Integer> node1,LinkListUitl.Node<Integer> node2){
        if(node1==null)
            return node2;
        if(node2 == null)
            return node1;

        if(node1.value<= node2.value){
            node1.next=merge(node2,node1.next);
            return node1;
        }
        node2.next=merge(node1,node2.next);
        return node2;
    }

}

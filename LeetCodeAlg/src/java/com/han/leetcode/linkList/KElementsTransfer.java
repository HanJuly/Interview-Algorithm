package com.han.leetcode.linkList;

import com.han.leetcode.linkList.util.LinkListUitl;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KElementsTransfer {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        LinkListUitl.Node<Integer> head = LinkListUitl.builder(nums);
        LinkListUitl.printLinkList(head);
        head = transfer(head,3);
        LinkListUitl.printLinkList(head);

    }

    public  static LinkListUitl.Node<Integer> transfer(LinkListUitl.Node<Integer> head, int k) {
        if(head == null)
            return null;

        LinkListUitl.Node<Integer> tail = null;
        tail = head;
        for (int i = 0; i < k - 1; i++) {
            if(tail == null)
                return head;
            tail = tail.next;
        }

        LinkListUitl.Node<Integer> curr = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            LinkListUitl.Node<Integer> temp = curr.next;
            curr.next = tail;
            tail = curr;
            if(i == k -1){

                head.next = transfer( temp, k);
                break;
            }
            curr = temp;
        }

        return curr;
    }
}

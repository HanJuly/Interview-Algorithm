package com.han.leetcode.linkList.util;

public class LinkListUitl {

    public static  <T> Node<T> builder(T[] arr){
        Node<T> head = null;
        Node<T> prov = null;
        for (int i = 0; i < arr.length; i++) {
            T t = arr[i];
            if(i == 0){
                head = new Node<>(t);
                prov = head;
            }else {
                Node<T> curr = new Node<>(t);
                prov.next = curr;
                prov = curr;
            }
        }
        return head;
    }

    public static  <T>void  printLinkList(Node<T> head){
        while (head!= null){

            System.out.print(head.value +"==>");
            head = head.next;
        }

        System.out.println();
    }

  public static class Node<T>{
       public   T value;
       public Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }
}

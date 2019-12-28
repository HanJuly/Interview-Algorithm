package com.han.leetcode.graph.base;

import java.util.ArrayList;
import java.util.List;

public class GraphBuiler {

    public static void main(String[] args) {
        Integer[] nodes ={1,2,3,4};
        test(nodes);
    }

    public static  <T> List<Node<T>> builder(T[] value){
        List<Node<T>> start = new ArrayList<>();
        for (T t : value) {
            start.add(new Node<T>(t));
        }
        return start;

    }

    public static <T> void test(T[] value){
        List<Node<T>> graph = builder(value);

            graph.get(0).setNext(new Node<T>(value[1])).setNext(new Node<T>(value[2]));
            graph.get(1).setNext(new Node<T>(value[3]));
            graph.get(2).setNext(new Node<T>(value[3]));


        for (Node<T> tNode : graph) {
            while (tNode != null){
                System.out.print(tNode.getValue() +"==>");
                tNode=tNode.getNext();
            }
                System.out.println("");
        }
    }
}

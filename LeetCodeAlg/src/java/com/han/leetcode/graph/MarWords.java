package com.han.leetcode.graph;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * LeetCode  第 269 题，火星字典：现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个不为空的单词列表。因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。您需要根据这个输入的列表，还原出此语言中已知的字母顺序。



 示例 1

 输入:

 [ "wrt", "wrf","er","ett", "rftt"]

 输出: "wertf"



 示例 2

 输入:
 [ "z", "x"]

 输出: "zx"



 示例 3
 输入:
 [ "z",  "x","z"]



 输出: ""

 1.首先这些输入的字符串都是按顺序排序的
 2.这个顺序是火星文的顺序
 3.使用邻接表构建拓扑
 4.使用深度遍历拓扑排序
 5.使用loop集合去每一层去重
 6.挂广度优先无法从摸一个点开始，而深度优先可以
 */
public class MarWords {
    public static void main(String[] args) {
        String[] words = {"wrt" , "wrf" , "er" ,"ett","rftt"};
        Map<Character, List<Character>> map = new MarWords().builderTopo(words);
//        Map<Character, List<Character>> map = new HashMap<>();
//        List<Character> ls1= new ArrayList<>();
//        ls1.add('a');
//
//        List<Character> ls2= new ArrayList<>();
//        ls2.add('b');
//        List<Character> ls3= new ArrayList<>();
//        ls3.add('c');
//        map.put('c',ls1);
//        map.put('a',ls2);
//        map.put('b',ls3);
        System.out.println(new MarWords().deep(map));
    }

    private Map<Character,List<Character>> builderTopo(String[] words){
        Map<Character,List<Character>> graph = new HashMap<>();
        for(int i=0;i<words.length-1;i++){
            String  w1= words[i];
            String  w2= words[i+1];
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                Character c1= j< w1.length()?w1.charAt(j):null;
                Character c2= j< w2.length()?w2.charAt(j):null;
                if(c1!=null&&!graph.containsKey(c1))
                    graph.put(c1,new ArrayList<>());

                if(c2!=null&&!graph.containsKey(c2))
                    graph.put(c2,new ArrayList<>());


                if(c1!=null&&c2 != null && c1 != c2 && !graph.get(c1).contains(c2))
                    graph.get(c1).add(c2);

            }
        }


        return graph;
    }

    private String deep(Map<Character,List<Character>> grapch){
        Stack<Character> stack = new Stack<>();
        Set<Character> loop = new HashSet<>();
        Set<Character> visited = new HashSet<>();
            for(Character c: grapch.keySet()){
                if(visited.contains(c))
                    continue;

                if(!travser(loop,visited,grapch,c,stack))
                    return "有环";
            }
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty())
                result.append("=="+stack.pop());

        return result.toString();
    }

    private boolean travser(Set<Character> loop,Set<Character> visited,Map<Character,List<Character>> grapch,Character u,Stack<Character> stack){
        if(u == null)
            return true;
        loop.add(u);
        visited.add(u);
        for(int i=0;i< grapch.get(u).size();i++){
            Character c1 = grapch.get(u).get(i);
            //一定要先判断loop，否则你的是包含跳过，那就达不到判断环
            if(loop.contains(c1))
                return false;

            if(visited.contains(c1))
                continue;

            if(!travser(loop,visited,grapch,c1,stack))
               return false;


        }

        loop.remove(u);
        stack.push(u);
        return true;
    }


}

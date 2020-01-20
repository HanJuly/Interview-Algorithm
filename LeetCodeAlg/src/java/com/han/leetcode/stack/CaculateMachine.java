package com.han.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1.使用sign符号，先赋值在计算的方式就不必回头
 * 2.队列最后一定要加一个+加号触发最后一个符号的运算
 * 3.使用递归计算括号内的值
 * 4.判断右括号要再赋值后，才能避免内层的递归队列多出一个符号
 */
public class CaculateMachine {
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();
        String temp = "10/(20+1-2)*2";
        for (int i =0;i< temp.length();i++){
            Character c = temp.charAt(i);
            queue.offer(c);
        }
        queue.offer('+');
        System.out.println(new CaculateMachine().caculate(queue));

    }

    private double caculate(Queue<Character> characters){
        double num =0;
        Character sgin='+';
        Stack<Double> stack = new Stack<>();
        while (!characters.isEmpty()){
            Character c = characters.poll();
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }else if(c.equals('(')){
                num=caculate(characters);

            }
            else {
                if(sgin.equals('+')){
                    stack.push((double)num);
                }else if(sgin.equals('-')){
                    stack.push((double)-num);
                }else if(sgin.equals('*')){
                    stack.push(stack.pop()*num);
                }else if(sgin.equals('/')){
                    stack.push(stack.pop()/num);
                }



                sgin=c;
                num=0;

                //写在赋值的后面，才能避免内层的递归队列多出一个符号
                if(sgin.equals(')'))
                    break;
            }
        }

        double sum = 0;
        while (!stack.isEmpty()){
            double v = stack.pop();
            sum+=v;
        }

        return sum;
    }
}

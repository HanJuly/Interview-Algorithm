package com.han.leetcode.greed;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode 第 253 题，会议室II，
 * 给定一系列会议的起始时间和结束时间，求最少需要多少个会议室就可以让这些会议顺利召开。
 */
public class Meeting {

    public static void main(String[] args) {
        Internal[] internals = {new Internal(7,10),new Internal(8,10),
                new Internal(9,12),new Internal(9,10),new Internal(9,15)};
        int meetNums = new Meeting().acquiereMeetings(internals);
        System.out.println(meetNums);
    }

    private int acquiereMeetings(Internal[] internals){
        if(internals==null || internals.length==0)
            return -1;
        Arrays.sort(internals,(a,b)->(a.start-b.start));
        PriorityQueue<Internal> meets = new PriorityQueue<>((a,b)->(b.end-a.end));
        meets.offer(internals[0]);
        for (int i = 1; i < internals.length; i++) {
            Internal internal = internals[i];
            Internal meet= meets.poll();
            if(internal.start >=meet.end){
                meet.end=internal.end;
            }else {
                meets.offer(internal);
            }

            meets.offer(meet);

        }

        return meets.size();
    }
    private static class Internal{
        public Internal(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start;
        public int end;
    }
}

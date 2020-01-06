package com.han.leetcode.binarySearch;

public class NormalSearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 7;


        int pos=new NormalSearch().search(nums,target);

        System.out.println("Target pos is:"+pos);

    }

    private int search(int[] nums,int target){
        int low = 0;
        int height = nums.length-1;
        while(low < height){
            int middle = low + (height-low)/2;

            if(nums[middle] == target){
               return middle;
            }else if (nums[middle] < target){
                low = middle+1;
            }else{
                height = middle-1;
            }
        }
        return -1;
    }


}

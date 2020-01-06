package com.han.leetcode.binarySearch;

/**
 * 搜索第一个大于目标值的数
 *
 * 细节： 如果搜索的数是数组的元素的话，搜索第一个大于，当等于时low向前推进，搜索第一个小于height
 */
public class SearchFirstMoreThan {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 5;


        int pos=new SearchFirstMoreThan().search(nums,target);

        System.out.println("Fist more than Target pos is:"+pos);

    }

    private int search(int[] nums, int target) {
        int low = 0;
        int height = nums.length-1;
        while(low <= height){
            int middle = low + (height-low)/2;

            if(nums[middle] > target && (middle == 0 || nums[middle-1] <= target) ){
                return middle;
            }

            if (nums[middle] <= target){
                low = middle+1;
            }else{
                height = middle-1;
            }
        }
        return -1;
    }


}

package com.han.leetcode.binarySearch;

/**
 * 搜索重复连续数字的上下边界
 *
 * 细节：
 *   先判断位置，然后在比较傍边的值，否则溢出
 *   nums[middle] == target && (middle == 0 || nums[middle-1] < target)
 *
 *   判断大于小于时要注意等于情况，因为等于分两种情况，等于 && 是上下边界
 */
public class SearchBorder {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,5,6,7,8,9};
        int target = 5;


        int pos=new SearchBorder().searchBottom(nums,target);
        int topPos=new SearchBorder().searchTop(nums,target);

        System.out.println("Target bottom pos is:"+pos);
        System.out.println("Target top pos is:"+topPos);

    }

    private int searchBottom(int[] nums, int target) {
        int low = 0;
        int height = nums.length-1;
        while(low <= height){
            int middle = low + (height-low)/2;

            if(nums[middle] == target && (middle == 0 || nums[middle-1] < target) ){
                return middle;
            }else if (nums[middle] < target){
                low = middle+1;
            }else{
                height = middle-1;
            }
        }
        return -1;
    }

    private int searchTop(int[] nums, int target) {
        int low = 0;
        int height = nums.length-1;
        while(low <= height){
            int middle = low + (height-low)/2;

            if(nums[middle] == target && (middle == nums.length-1 ||  nums[middle+1] > target) ){
                return middle;
            }else if (nums[middle] <= target){
                low = middle+1;
            }else{
                height = middle-1;
            }
        }
        return -1;
    }
}

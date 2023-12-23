package com.java.coding.problem;

import java.util.Arrays;

/**
 * Rotate an array of n elements ti the right by k steps
 */
public class RotateArrayInJava {
    public static void main(String[] args) {
        int[] source = {1,2,3,4,5,6,7};
        int rotate = 3;
        //solution 1
        rotateSolution1(source, rotate);
        //solution 2
        rotateSolution2(source, rotate);
    }

    //intermediate array
    public static void rotateSolution1(int[] nums, int k) {
        if (nums.length < k)
            k%=nums.length;
        int[] result = new int[nums.length];

        for (int i=0; i<k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        int j=0;
        for (int i=k; i< nums.length; i++) {
            result[i] = nums[j];
            j++;
        }
        nums = Arrays.copyOf(result, result.length);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 1. Divide the array into 2 parts
     * 2. reverse first part
     * 3. reverse second part
     * 4. reverse the whole array
     * @param nums
     * @param k
     */
    public static void rotateSolution2(int[] nums, int k) {
        int a = nums.length - k;
        reverseArray(nums, 0, a-1);
        reverseArray(nums, a, nums.length-1);
        reverseArray(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseArray(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1)
            return;
        while (left<right) {
            arr[left] = arr[left] + arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] = arr[left] - arr[right];
            left++;
            right--;
        }
    }
}

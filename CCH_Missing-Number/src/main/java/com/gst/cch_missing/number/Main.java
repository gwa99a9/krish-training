/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gst.cch_missing.number;

import java.util.Arrays;

/**
 *
 * @author OBITO
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 7, 9};
        System.out.println(Arrays.toString(nums));
        findTheMissingNumber(nums);
    }

//TODO : use scanner for inputs
//TODO : use delimiter
//TODO : sort the int array
//TODO : create test classess

    private static void findTheMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i + 1] - nums[i]) == 2) {
                System.out.println(nums[i] + 1);
            } else if ((nums[i + 1] - nums[i]) >= 3) {
                System.out.println("Invalid Sequence");
                break;
            }
        }
    }
}

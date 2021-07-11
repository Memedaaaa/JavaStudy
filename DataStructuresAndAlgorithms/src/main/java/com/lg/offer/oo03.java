package com.lg.offer;

import java.util.HashSet;
import java.util.Set;

public class oo03 {
    /**
     * 数组中重复的数字
     *
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[1]);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean flag =  set.add(nums[i]);
            if(!flag){
                return nums[i];
            }
        }
        return -1;
    }

}

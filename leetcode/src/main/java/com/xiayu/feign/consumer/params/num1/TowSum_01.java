package com.xiayu.feign.consumer.params.num1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/19 21:28
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例: 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]。1.
 */
public class TowSum_01 {

    /**
     * 方法思路
     * 一 . 哈希表法
     * 时间复杂度  O(n)
     * 空间复杂度 O(n)
     * <p>
     * 二 。暴力破解法
     * 时间复杂度  O(n2)
     * 空间复杂度 O(1)
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5, 6};
        int target = 5;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        /**
         * 创建一个hashMap 将数组中的数挨个放进去，在放进去的过程中，检验这个数是否符合体条件
         */
        //Map将结果封装后校验
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            //map key 中是否包含结果对
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                j = map.get(target - nums[i]);
                break;
            }
        }
        return new int[]{j, i};
    }

    public static int[] twoSum_2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

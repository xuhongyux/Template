package com.xiayu.params.num1;

/**
 * Description:
 * 4: 寻找两个正序数组合并后的中位数
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/3 16:23
 */
public class FindMedian_04 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5,8,9,20,24,56,78};
        int[] nums2 = {2, 4};
        String s = solution_1(nums1, nums2);
        double v = findMedianSortedArrays(nums1, nums2);
        System.out.println(v);
        System.out.println(s);
    }


    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0){
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
    /**
     * 先合并后求值
     * @param nums1
     * @param nums2
     * @return
     */
    private static double solution_2(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {

                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
    private static String solution_1(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int sumLength = nums1Length + nums2Length;
        int sumLength_last = 0;
        int result = 0;
        int j = 0;
        int k = 0;
        if (sumLength % 2 == 1) {
            sumLength = sumLength/2 +1 ;
            for (int i = 0; i < sumLength; i++) {
                if (nums1[j] < nums2[k]) {
                    if(nums1Length-1 > j){
                        j++;
                    }else {
                        k++;
                    }

                } else {
                    if(nums2Length-1 > k) {
                        k++;
                    }else {
                        j++;
                    }

                }
            }
            int z= nums1[j-1];
            result = Math.max(nums1[j-1],nums2[k-1]);
        } else {
            sumLength = sumLength/2  ;
            sumLength_last = sumLength/2 +1 ;

            for (int i = 0; i < sumLength_last; i++) {
                if (nums1[j] < nums2[k]) {
                    j++;
                } else {
                    k++;
                }
            }
        }


        return String.valueOf(result);
    }
}

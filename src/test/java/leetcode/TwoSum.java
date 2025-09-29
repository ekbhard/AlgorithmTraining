package leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.testcontainers.shaded.org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class TwoSum {

    @Test
    public void test() {

        twoSum(new int[]{2, 7, 11, 15}, 9);
        twoSum(new int[]{10, 10, 11, 15}, 9);
        twoSum(new int[]{3, 3}, 6);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == nums.length - 1) {
                    break;
                }
                if (i == j) {
                    continue;
                }
                int diff = target - nums[i] - nums[j];
                if (diff == 0) {
                    result = new int[]{i, j};
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSumV2(int[] nums, int target) {
        int first;
        int second;
        for (int i = 0; i < nums.length ; i++) {
            first = i;
            int find = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i==j){
                    continue;
                }
                if (nums[j] == find) {
                    second = j;
                    return new int[]{first, second};
                }
            }
        }
        return new int[]{0, 0};
    }
}

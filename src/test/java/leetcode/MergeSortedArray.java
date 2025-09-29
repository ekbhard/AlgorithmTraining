package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArray {

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        int[] result = {1, 2, 2, 3, 5, 6};
        Assert.assertArrayEquals(merge(nums1, 3, nums2, 3), result);
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        return nums1;
    }
}

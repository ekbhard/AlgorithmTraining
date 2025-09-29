package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {

    @Test
    public void task() {
        //отсоритрованный массив

        int[] nums1 = {1, 2, 3, 4, 5, 7, 8, 10, 12, 100, 210};
        binary_search(nums1, 5);
        binary_search(nums1, 10);
        binary_search(nums1, 1001);

    }

    private void binary_search(int[] nums, int needNum) {
        int low = 0;
        int hihg = nums.length - 1;
        while (low <= hihg) {
            int mid = (low + hihg) / 2;
            int currentNum = nums[mid];
            if (needNum == currentNum) {
                System.out.println("number is ");
                System.out.println(mid + 1);
                return;
            }
            if (needNum > currentNum) {
                low = mid + 1;
            }
            if (needNum < currentNum) {
                hihg = mid - 1;
            }
        }
        System.out.println("no number");
    }
}

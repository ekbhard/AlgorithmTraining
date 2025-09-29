package neetcode;

import org.junit.Test;

public class ArraysAndHashingTest {

    @Test
    public void test_hasDuplicates() {
        int[] array = new int[4];
        array[0] = 2;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        ArraysAndHashing.hasDuplicates(array);
    }

    @Test
    public void test_anagram() {
        boolean result1 = ArraysAndHashing.isAnagram("racecar",
                "carrace");

        assert result1;

        boolean result2 = ArraysAndHashing.isAnagram("jam",
                "jar");

        assert !result2;
    }

    @Test
    public void test_products_except_Self() {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        // Вывод результата
        for (int num : result) {
            System.out.print(num + " "); // 24 12 8 6
        }
    }


    /*
    https://neetcode.io/problems/products-of-array-discluding-self
        //Products of Array Except Self
     */

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }


}

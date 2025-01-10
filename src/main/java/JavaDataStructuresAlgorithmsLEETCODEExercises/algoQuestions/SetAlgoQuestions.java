package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetAlgoQuestions {


    /**
     * Given two integer arrays arr1 and arr2, and an
     * integer target, write a method named
     * findPairs that finds all pairs of integers
     * such that one integer is from arr1,
     * the other is from arr2, and their
     * sum equals the target value.
     * <p>
     * int[] arr1 = {1, 2, 3, 4, 5};
     * int[] arr2 = {2, 4, 6, 8, 10};
     * int target = 7;
     * <p>
     * List<int[]> pairs = findPairs(arr1, arr2, target);
     * <p>
     * /*
     * Expected output:
     * [5, 2]
     * [3, 4]
     * [1, 6]
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> list = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();

        for (int num : arr1) {
            integers.add(num);
        }

        for (int num : arr2) {
            int result = target - num;
            if (integers.contains(result)) {
                list.add(new int[]{result, num});
            }
        }
        return list;
    }

    /**
     * Input: An unsorted array of integers, nums.
     * Output: An integer representing the length of the longest consecutive sequence in nums.
     *
     * @param arr1
     * @return
     */

    /*
    public static int longestConsecutiveSequence(int[] arr1) {
        if (arr1.length == 0 || arr1.length == 1) {
            return 0;
        }
        //добавляем все сюда
        Set<Integer> numSet = new HashSet<>();

        for (int i : arr1) {
            numSet.add(i);
        }
        int max = 0;

        for (int num : numSet) {
            if (numSet.contains(num - 1)) {
                int current = num;
                int currentMax = 1;

                while (numSet.contains(current + 1)) {
                    currentMax++;
                    current++;
                }

                max = Math.max(max, currentMax);
            }
        }
        return max;
    }

     */
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int max = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentMax = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentMax++;
                }
                max = Math.max(max,
                        currentMax);
            }

        }
        return max;
    }
}

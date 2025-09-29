package stepikAlgo;

import org.junit.Test;

import java.util.*;

public class Algorithm {


    //написать числа фибоначи

    @Test
    public void fibonachiTest() {
        System.out.println(Arrays.toString(fibonachi(3)));
        System.out.println(fibonachi2(3));
    }

    //задача состоит в проверке правильности скобок
    // {()} правильно
    // {{{) не правильно и тд
    @Test
    public void rightBracketsFinder() {

        System.out.println(isBalansed("{}"));
        System.out.println(isBalansed("{()}"));
        System.out.println(isBalansed("({)}"));
        System.out.println(isBalansed("((}}{}"));
        System.out.println(isBalansed("({}[])[{{{}}}]"));
        System.out.println(isBalansed("{[(])}"));
    }

    /*
    подается на вход массив из чисел
    тужно окном определенной размерности пройтись и найти минимум среди этого окна
    Sliding Window Minimum - задача в сети
     */
    @Test
    public void slidingMinimumWindow() {

        int[] arr = {10, 20, 30, 50, 10, 70, 30};

        int[] arr2 = {1,3,-1,-3,5,3,6,7};

        slidingWindowQueue(arr, 3);

        slidingWindow(arr2, 3);


    }

    static int[] slidingWindow(int nums[], int k) {

        int[] mins = new int[nums.length - k + 1];


        for (int i = 0; i < nums.length - k + 1; i++) {
            int current_min = nums[i];

            for (int j = 0; j < k; j++) {
                if (current_min < nums[i + j]) {
                    current_min = nums[i + j];
                }
            }
            mins[i] = current_min;
        }

        System.out.println(Arrays.toString(mins));
        return mins;
    }


    public static int[] slidingWindowQueue(int[] arr, int windowSize) {
        if (arr == null || arr.length == 0 || windowSize <= 0 || windowSize > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] minimums = new int[arr.length - windowSize + 1];
        Deque<Integer> queue = new LinkedList<>();


        for (int i = 0; i < arr.length; i++) {
            // Remove elements from the back of the queue that are out of the current window
            while (!queue.isEmpty() && queue.peekFirst() < i - windowSize + 1) {
                queue.pollFirst();
            }

            // Remove elements from the front of the queue that are greater than the current element
            while (!queue.isEmpty() && arr[queue.peekLast()] > arr[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);

            // Add the minimum of the current window to the result array
            if (i >= windowSize - 1) {
                minimums[i - windowSize + 1] = arr[queue.peekFirst()];
            }
        }

        System.out.println(Arrays.toString(minimums));
        return minimums;
    }

    private boolean isBalansed(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (character == '{'
                    || character == '('
                    || character == '[') {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if ((top == '[' && character != ']') ||
                        (top == '{' && character != '}') ||
                        (top == '(' && character != ')')
                ) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }


    public int[] fibonachi(int n) {
        int[] fibArray = new int[n];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

    public int fibonachi2(int n) {
        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[n];
    }


}

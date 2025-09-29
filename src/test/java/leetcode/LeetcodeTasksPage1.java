package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetcodeTasksPage1 {

    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .map(array -> Arrays.stream(array).sum())
                .max(Comparator.naturalOrder()).get();
    }

    @Test
    public void maximumWealthTest() {
        int[][] sds = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(maximumWealth(sds));
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 5 == 0) && (i % 3 == 0)) {
                list.add("FizzBuzz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else list.add(String.valueOf(i));
        }
        return list;
    }

    @Test
    public void fizzBuzzTest() {
        System.out.println(fizzBuzz(3));
    }

    public int numberOfSteps(int num) {

        return helper(num, 0);
    }

    private int helper(int num, int step) {
        if (num == 0) return step;
        if (num % 2 == 0) {
            num = num / 2;
        } else {
            num = num - 1;
        }
        return helper(num, step + 1);
    }

    @Test
    public void numberOfStepsTest() {
        System.out.println(numberOfSteps(14));
    }
}

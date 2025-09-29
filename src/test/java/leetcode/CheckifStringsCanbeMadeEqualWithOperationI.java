package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CheckifStringsCanbeMadeEqualWithOperationI {

    @Test
    public void task() {

        //https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/

        Assert.assertFalse(canBeEqual("abcd", "dacb"));
        Assert.assertTrue(canBeEqual("abcd", "cdab"));
        Assert.assertTrue(canBeEqual("bnxw", "bwxn"));
        Assert.assertTrue(canBeEqual("bbbb", "bbbb"));
    }

    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1Array = s1.toCharArray();
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (i - j == 2) {
                    if (s1Array[i] == s2.charAt(i)) {
                        continue;
                    } else {
                        char x = s1Array[i];
                        char y = s1Array[j];
                        s1Array[j] = x;
                        s1Array[i] = y;
                        if (Arrays.equals(s1Array, s2.toCharArray())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


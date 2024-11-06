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
}

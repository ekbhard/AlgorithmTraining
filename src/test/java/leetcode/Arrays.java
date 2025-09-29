package crackTheIntrervue;

import org.junit.Test;

import java.util.StringJoiner;

import static java.util.Arrays.sort;

public class Arrays {

    @Test
    public void test() {

//        System.out.println(isUniqueChars("deeqs"));
//        System.out.println(isUniqueChars("deqs"));
//
//        System.out.println(canCreateWord("dog", "god"));
//
//        System.out.println(changeString("awdawd adwas dasdw svcd  "));
//
//        System.out.println(isPalindrome("ookook"));
//        System.out.println(isPalindrome("ookoo"));
//        System.out.println(isPalindrome("ookkoo"));
//        System.out.println(isPalindrome("ookkoooo"));
//
//        System.out.println("---------------------");
//
//        System.out.println(modify("pale", "ple"));
//        System.out.println(modify("pales", "pale"));
//        System.out.println(modify("pale", "bale"));
//        System.out.println(modify("pale", "bake"));
//        System.out.println(modify("apple", "aple"));
//        System.out.println(modify("aple", "apple"));
//
//        System.out.println("---------------------");

        System.out.println(stringCompression("aaabbbccc"));
        System.out.println(stringCompression("abc"));
        System.out.println(stringCompression("defgggutt"));
        System.out.println(stringCompression("ааЬсссссааа"));

    }

    // Алгоритм который проверяет все ли символы встречаеются в строке только один раз
    public boolean duplicatedChars(String text) {
        char[] testArray = text.toCharArray();
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (testArray[i] == testArray[j]) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return true;
        }
        boolean[] chars_boolean = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (chars_boolean[val]) {
                return false;
            }
            chars_boolean[val] = true;
        }
        return true;
    }

    //Для двух строк напишите метод который опредляет
    // можно ли из букв одой строки составить другую

    public boolean canCreateWord(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        sort(charArray1);
        sort(charArray2);
        return java.util.Arrays.equals(charArray1, charArray2);
    }

    // напишите метод который все пробелы замсняет на %20

    public String changeString(String text) {
        String[] textArray = text.trim().split(" ");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < textArray.length; i++) {
            builder.append(textArray[i]).append("%20");
        }

        return builder.toString();

    }

    // является ли строка палиндромом

    public boolean isPalindrome(String text) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    //задачка с модифицирующими операциями. Существуют их три
    // удалоенеие вставка и замена. Проверить что между операциями только доин шаг или 0

    public boolean modify(String s1, String s2) {

        if (Math.abs(s1.length() - s2.length()) >= 2) {
            return false;
        }
        int min = Math.min(s1.length(), s2.length());
        int tryCount = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < min; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    tryCount++;
                }
                if (tryCount == 2) {
                    return false;
                }
            }
        } else {
            if (s1.length() > s2.length()) {
                return oneEditInsert(s1, s2);
            } else {
                return oneEditInsert(s2, s1);
            }

        }
        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        int tryCount = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                tryCount++;
                index1++;
            } else {
                index1++;
                index2++;
            }
            if (tryCount == 2) {
                return false;
            }
        }
        return true;
    }

    // алгоритм простейшего сжатия строк типа aaabbbcccc - 3a3b4c

    public String stringCompression(String text) {
        char[] charArray = text.toCharArray();
        StringBuilder builder = new StringBuilder();
        char currentChar = charArray[0];
        int currentCount = 0;

        for (int i = 1; i < charArray.length; i++) {
            if (currentChar != text.charAt(i)) {
                currentCount++;
                builder.append(currentCount).append(currentChar);
                currentCount = 0;
            } else {
                currentCount++;
            }
            currentChar = text.charAt(i);

            if (i == charArray.length - 1) {
                builder.append(currentCount).append(currentChar);
            }
        }
        return builder.toString();
    }



}

package x5lessons.base;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BaseExamples {

    @Test
    public void test_Two_Sum() {
        /*
       Дан массив целых чисел nums и целое число target. Нужно найти индексы двух чисел в массиве, которые в сумме дают target.

       Гарантируется, что ровно одно решение существует, и один и тот же элемент нельзя использовать дважды.
         */

        // Тест 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println(Arrays.toString(result1)); // Ожидается [0, 1]

        // Тест 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println(Arrays.toString(result2)); // Ожидается [1, 2]

        // Тест 3 (дополнительный)
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println(Arrays.toString(result3)); // Ожидается [0, 1]
    }

    public int[] twoSum(int[] nums, int target) {

        if (nums.length <= 1) {
            return new int[]{0, 0};
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int current = nums[j];
            if (map.containsKey(current)) {
                if (j != map.get(current)) {
                    return new int[]{j, map.get(current)};
                }
            }
        }
        return new int[]{0, 0};
    }

    @Test
    public void test_Remove_Duplicates_from_Sorted_Array() {
        // Тест 1
        int[] nums1 = {1, 1, 2};
        int len1 = removeDuplicates(nums1);
        System.out.println(len1);  // Ожидается 2
        System.out.println(Arrays.toString(Arrays.copyOf(nums1, len1)));  // [1, 2]

        // Тест 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = removeDuplicates(nums2);
        System.out.println(len2);  // Ожидается 5
        System.out.println(Arrays.toString(Arrays.copyOf(nums2, len2)));  // [0, 1, 2, 3, 4]

        // Тест 3 (нет дубликатов)
        int[] nums3 = {1, 2, 3};
        int len3 = removeDuplicates(nums3);
        System.out.println(len3);  // Ожидается 3
        System.out.println(Arrays.toString(Arrays.copyOf(nums3, len3)));  // [1, 2, 3]
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];

            }
        }
        return ++j;
    }

    @Test
    public void test_max_stock() {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));  // Ожидается 5

        // Тест 2 (нет прибыли)
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));  // Ожидается 0

        // Тест 3 (минимальная длина)
        int[] prices3 = {1, 2};
        System.out.println(maxProfit(prices3));  // Ожидается 1
    }

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }

    @Test
    public void test_max_sub_array() {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // Ожидается 6

        // Тест 2 (все числа отрицательные)
        int[] nums2 = {-2, -1, -3, -4};
        System.out.println(maxSubArray(nums2)); // Ожидается -1

        // Тест 3 (один элемент)
        int[] nums3 = {5};
        System.out.println(maxSubArray(nums3)); // Ожидается 5
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }


    @Test
    public void test_group_anagrams() {

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // Ожидается: [ ["bat"], ["nat","tan"], ["ate","eat","tea"] ]

        // Тест 2 (пустой ввод)
        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // Ожидается: [ [""] ]

        // Тест 3 (один элемент)
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
        // Ожидается: [ ["a"] ]
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray); // Или Arrays.toString(charArray)

            // Если ключа нет — создаём новый список
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Добавляем слово в соответствующий список
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    @Test
    public void test_world_pattern() {

        String strs11 = "dog cat cat dog";
        String strs12 = "abba";
        System.out.println(wordPattern(strs12, strs11));
        // Ожидается: true

        String strs21 = "dog cat cat fish";
        String strs22 = "abba";
        System.out.println(wordPattern(strs22, strs21));
        // Ожидается: false

        String strs31 = "dog dog dog dog";
        String strs32 = "abba";
        System.out.println(wordPattern(strs32, strs31));
        // Ожидается: false

        String strs41 = "dog dog dog cat";
        String strs42 = "abba";
        System.out.println(wordPattern(strs42, strs41));
        // Ожидается: false
    }


    public boolean wordPattern(String pattern, String s) {

        if (pattern.length() != s.split(" ").length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        Set<String> seen = new HashSet<>();

        char[] charsPattern = pattern.toCharArray();

        String[] stringArray = s.split(" ");

        for (int i = 0; i < pattern.length(); i++) {

            if (map.containsKey(charsPattern[i])) {
                String current = map.get(charsPattern[i]);
                if (!current.equals(stringArray[i])) {
                    return false;
                }
            } else {

                if (seen.contains(stringArray[i])) {
                    return false;
                }

                map.put(charsPattern[i], stringArray[i]);
                seen.add(stringArray[i]);
            }

        }
        return true;

    }

    @Test
    public void testIsValid() {
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
        assertFalse(isValid("([)]"));
        assertTrue(isValid("{[]}"));
        assertFalse(isValid("]"));
        assertTrue(isValid(""));
    }

    /*
    20. Valid Parentheses

    Условие задачи:

Напишите метод, который принимает строку s, состоящую только из символов '(', ')', '{', '}', '[' и ']', и проверяет, является ли эта строка валидной. Строка считается валидной, если:

Открытые скобки закрываются скобками того же типа.

Открытые скобки закрываются в правильном порядке.

Каждая закрытая скобка имеет соответствующую открытую скобку того же типа.
     */


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();

                if (current == '}' && top != '{') {
                    return false;
                } else if (current == ']' && top != '[') {
                    return false;
                } else if (current == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(isPalindrome("race a car"));
        assertTrue(isPalindrome(" "));
        assertTrue(isPalindrome("abba"));
        assertFalse(isPalindrome("abc"));
        assertTrue(isPalindrome("Level"));
        assertFalse(isPalindrome("0P")); // Проверка на цифры и регистр
    }

    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String string = builder.toString();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, singleNumber(new int[]{1}));
        assertEquals(7, singleNumber(new int[]{7, 3, 5, 3, 5})); // Уникальный элемент в середине
        assertEquals(-5, singleNumber(new int[]{-1, -1, -5})); // Отрицательные числа
    }

    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int i : nums) {
            ans ^= i;
        }

        return ans;
    }


    /*
    Условие задачи:
Напишите метод, который принимает строку s и возвращает длину наибольшей подстроки без повторяющихся символов.

Примеры:

s = "abcabcbb" → 3 (подстрока "abc").

s = "bbbbb" → 1 (подстрока "b").

s = "pwwkew" → 3 (подстрока "wke" или "kew").
     */


    @Test
    public void testLengthOfLongestSubstring() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, lengthOfLongestSubstring("")); // Пустая строка
        assertEquals(1, lengthOfLongestSubstring(" ")); // Один пробел
        assertEquals(2, lengthOfLongestSubstring("au")); // Крайний случай
        assertEquals(3, lengthOfLongestSubstring("dvdf")); // Проверка на перекрытие
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (set.add(s.charAt(right))) {
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            result = Math.max(result, right - left);
        }


        return result;
    }


    @Test
    public void testClimbStairs() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(5, climbStairs(4));
        assertEquals(1, climbStairs(1)); // Одна ступенька
        assertEquals(1, climbStairs(0)); // Крайний случай (по условию LeetCode n ≥ 0)
        assertEquals(89, climbStairs(10)); // Проверка на большие значения
    }

    /*
    dp[0] = 1
    dp[1] = 1
    dp[2] = dp[1] + dp[0] = 2
    dp[3] = dp[2] + dp[1] = 3
    dp[4] = dp[3] + dp[2] = 5
     */

    public int climbStairs(int n) {
        if (n <= 1) return 1; // Для n=0 и n=1

        int prev1 = 1; // dp[i-1]
        int prev2 = 1; // dp[i-2]
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1; // Обновляем значения для следующей итерации
            prev1 = current;
        }

        return current;
    }
}

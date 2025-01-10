package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class MapAlgoQuestions {

    //вернуть true если в первом массиве есть хотя бы одно число из другого массива
    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : array1) {
            map.put(i,
                    true);
        }

        for (int j : array2) {
            if (map.get(j) != null) {
                return true;
            }
        }

        return false;
    }

    // найти все дупликаты в массиве
    public static List<Integer> findDuplicates(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> forReturn = new ArrayList<>();

        for (int i : nums) {
            Integer numberOfIntegers = map.get(i);
            if (numberOfIntegers == null) {
                map.put(i,
                        1);
            } else {
                map.put(i,
                        numberOfIntegers + 1);
            }
        }
        map.forEach((key, value) -> {
            if (value > 1) {
                forReturn.add(key);
            }
        });
        return forReturn;
    }

    //первое неповторяющееся число в массиве

    public static Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charCounts.put(c,
                    charCounts.getOrDefault(c,
                            0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    //вернуть лист листов где слова являются анаграмой
    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);
            List<String> values = map.get(canonical);
            if (values != null) {
                values.add(string);
                map.put(canonical,
                        values);
            } else {
                ArrayList<String> group = new ArrayList<>();
                group.add(string);
                map.put(canonical,
                        group);
            }
        }
        return new ArrayList<>(map.values());
    }

    //вернуть массив из индексов чисел сумма которых равна указанному числу

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberPerDiff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int compliment = target - num;
            if (numberPerDiff.containsKey(compliment)) {
                return new int[]{numberPerDiff.get(compliment), i};
            } else {
                numberPerDiff.put(num,
                        i);
            }
        }
        return new int[]{};
    }

    /*
    Идея заключается в следующем:
        1) Ты идёшь по массиву и последовательно считаешь префиксную сумму
            (сумма всех элементов от начала до текущего индекса).
        2) Для удобного поиска используем HashMap, которая будет хранить все префиксные суммы на каждом шаге.
        3) Как только текущая префиксная сумма минус target уже встречалась ранее, это означает,
        4) что мы нашли нужный подмассив, сумма которого равна target. Индексы между этими
            двумя префиксными суммами и будут ответом.
     */
    //вернуть подмассив из 2 чисел, которые являются индексами чисел от которого до которого сумма будет равна target
    public static int[] subarraySum(int[] nums, int target) {
        // Хэшмап будет хранить суммы как ключи и индексы как значения
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0,
                -1); // Изначально кладем сумму 0, чтобы учесть подмассивы с нулевого индекса

        int currentSum = 0; // Переменная для хранения префиксной суммы

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i]; // Увеличиваем текущую сумму на значение элемента

            // Проверяем, существует ли эта сумма ранее минус target в hashmap
            if (prefixSums.containsKey(currentSum - target)) {
                // Если нашли нужную разницу, возвращаем индексы начала и конца подмассива
                int startIndex = prefixSums.get(currentSum - target) + 1;
                return new int[]{startIndex, i};  // Возвращаем массив с двумя индексами
            }

            // В противном случае, сохраняем текущую сумму и её индекс
            prefixSums.put(currentSum,
                    i);
        }

        // Если подмассив не найден, возвращаем пустой массив
        return new int[0];
    }

}

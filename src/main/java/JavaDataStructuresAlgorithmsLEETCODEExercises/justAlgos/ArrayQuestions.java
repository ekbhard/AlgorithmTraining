package JavaDataStructuresAlgorithmsLEETCODEExercises.justAlgos;

import java.util.*;

public class ArrayQuestions {
	public static void main(String[] args) {
		String[] strings = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};

		String[] test2 = new String[]{"we", "say", ":", "yes", "!@#$%^&*()"};
		groupAnagrams(strings);

		int[] ints = new int[]{1, 2, 2, 3, 3, 2};

		var ee = topKFrequent(ints, 2);

		String encode = encode(Arrays.stream(test2).toList());

		decode(encode);

	}

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> numPerInteger = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int diff = target - num;
			if (numPerInteger.containsKey(diff)) {
				int foundedIndex = numPerInteger.get(diff);
				if (i < foundedIndex) {
					return new int[]{i, numPerInteger.get(diff)};
				} else {
					return new int[]{numPerInteger.get(diff), i};
				}
			} else {
				numPerInteger.put(num, i);
			}
		}
		return new int[]{};
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> letterPerTimes = new HashMap<>();
		for (String string : strs) {
			char[] chars = string.toCharArray();
			Arrays.sort(chars);
			String canonical = new String(chars);
			List<String> strings = letterPerTimes.get(canonical);
			if (letterPerTimes.containsKey(canonical)) {
				strings.add(string);
				letterPerTimes.put(canonical, strings);
			} else {
				ArrayList<String> group = new ArrayList<>();
				group.add(string);
				letterPerTimes.put(canonical, group);
			}
		}
		List<List<String>> forReturn = new ArrayList<>();
		letterPerTimes.forEach((k, v) -> {
			forReturn.add(v);
		});
		return forReturn;
	}

	/*

	Given an integer array nums and an integer k, return the k most frequent elements within the array.
	The test cases are generated such that the answer is always unique.
	You may return the output in any order.
	 */
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numsPerCount = new HashMap<>();
		for (int num : nums) {
			if (numsPerCount.containsKey(num)) {
				int count = numsPerCount.get(num);
				numsPerCount.put(num, count + 1);
			} else {
				numsPerCount.put(num, 1);
			}
		}
		ArrayList<int[]> list = new ArrayList<>();
		numsPerCount.forEach((key, value) -> list.add(new int[]{value, key}));
		list.sort((a, b) -> Integer.compare(b[0], a[0]));
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			int[] ints = list.get(i);
			result[i] = ints[1];
		}
		return result;
	}


	//encode and decode
	public static String encode(List<String> strs) {
		if (strs.isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();

		for (String str : strs) {
			builder.append(str.length());
			builder.append("%");
			builder.append(str);
		}
		return builder.toString();
	}

//	public static List<String> decode(String str) {
//		List<String> strings = new ArrayList<>();
//		char[] chars = str.toCharArray();
//		int i = 0;
//		while (i < chars.length) {
//			if (chars[i] == '%') {
//				int sizeOfString = Character.getNumericValue(chars[i - 1]);
//				StringBuilder builder = new StringBuilder();
//				for (int j = i + 1; j < i + sizeOfString + 1; j++) {
//					builder.append(chars[j]);
//				}
//				strings.add(builder.toString());
//				i = i + sizeOfString + 1;
//			}
//			i++;
//		}
//		return strings;
//	}

	public static List<String> decode(String str) {
		List<String> strings = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int j = i;
			while (str.charAt(j) != '%') {
				j++;
			}

			int sizeOfString = Integer.parseInt(str.substring(i, j));
			i = j + 1;
			j = i + sizeOfString;
			strings.add(str.substring(i, j));
			i = j;
		}
		return strings;
	}
}

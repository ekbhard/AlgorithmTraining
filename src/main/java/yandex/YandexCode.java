package yandex;

import java.util.*;

public class YandexCode {

	public static void main(String[] args) {
		// 88. Merge Sorted Array
		//1st case
		int[] nums1 = new int[]{1, 2, 2, 0, 0, 0};
		int[] nums2 = new int[]{1, 2, 5};

		merge(nums1, 3, nums2, 3);

		int[] nums3 = new int[]{1, 1, 2, 2, 2, 5};

		//2st case

		int[] nums4 = new int[]{1};
		int[] nums5 = new int[]{};

		merge(nums4, 1, nums5, 0);


		//485. Max Consecutive Ones

		int[] binary = new int[]{0, 1, 0, 0, 1, 1, 1, 0, 1, 1};
		int maxConsecutiveOnes = findMaxConsecutiveOnes(binary);

		assert maxConsecutiveOnes == 2;

		//605. Can Place Flowers

		int[] flowerbed = new int[]{1, 1, 0, 0, 0, 1, 1, 0, 1, 1};

		boolean b = canPlaceFlowers(flowerbed, 1);

		int[] flowerbed2 = new int[]{1, 0, 0, 0, 1, 1, 1, 0, 0, 0};

		boolean b2 = canPlaceFlowers(flowerbed2, 2);

		int[] flowerbed3 = new int[]{1, 0, 0, 0, 0, 0, 1};

		boolean b3 = canPlaceFlowers(flowerbed3, 2);

		int[] flowerbed4 = new int[]{1, 0, 0, 0, 1};

		boolean b4 = canPlaceFlowers(flowerbed4, 1);

		int[] flowerbed5 = new int[]{0, 1, 0};

		boolean b5 = canPlaceFlowers(flowerbed5, 1);


		//643. Maximum Average Subarray I

		int[] array = new int[]{1, 12, -5, -6, 50, 3};
//		int[] array = new int[]{-1};


		double maxAverage = findMaxAverage(array, 4);

		// 3. Longest Substring Without Repeating Characters

		lengthOfLongestSubstring("abcabcbb");

		///8. String to Integer (atoi)


		// 5. Longest Palindromic Substring

		longestPalindrome("cbbd");

		//31. Next Permutation
		int[] permArray = new int[]{3, 2, 1};
		nextPermutation(permArray);

		//56. Merge Intervals
		int[][] twoDimArray = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//		int[][] twoDimArray = {{1, 3}};
//		int[][] twoDimArray = {{1, 4}, {0, 4}};
		int[][] merge = merge(twoDimArray);

		//1441. Build an Array With Stack Operations

		int[] buildArray = {1,2,4};

		List<String> strings = buildArray(buildArray, 3);
	}

	public static List<String> buildArray(int[] target, int n) {
		ArrayList<String> steps = new ArrayList<>();
		int i = 0;

		for (int num : target) {
			while (i < num - 1) {
				steps.add("Push");
				steps.add("Pop");
				i++;
			}
			steps.add("Push");
			i++;
		}

		return steps;
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			} else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0;
		int max = 0;
		for (int i = 0; i <= nums.length - 1; i++) {
			if (nums[i] == 0) {
				max = 0;
			} else {
				max++;
				if (result < max) {
					result = max;
				}
			}
		}
		return result;
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (n == 0) {
			return true;
		}

		if (flowerbed.length == 0) {
			return false;
		}

		if (flowerbed.length == 1) {
			if (flowerbed[0] == 0) {
				return true;
			} else return false;
		}

		for (int i = 0; i <= flowerbed.length - 1; i++) {
			if (i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0) {
				flowerbed[i] = 1;
				n--;
				continue;
			}

			if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
				flowerbed[i] = 1;
				n--;
				continue;
			}
			if (flowerbed[i] == 0) {
				if (i != 0) {
					if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
						flowerbed[i] = 1;
						n--;
					}
				}
			}
		}
		return n <= 0;
	}


	public static double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++)
			sum += nums[i];
		int maxSum = sum;
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			maxSum = Math.max(maxSum, sum);
		}
		return (double) maxSum / k;
	}


	public static int lengthOfLongestSubstring(String s) {
		int left = 0;
		int right = 0;
		int maxLength = 0;

		Set<Character> characters = new HashSet<>();

		while (right <= s.length() - 1) {
			if (characters.add(s.charAt(right))) {
				right++;
			} else {
				characters.remove(s.charAt(left));
				left++;
			}
			maxLength = Math.max(maxLength, right - left);
		}

		return maxLength;
	}


	public int myAtoi(String s) {
		int result = 0;
		int sign = 1;
		int index = 0;

		if (s.isEmpty()) {
			return 0;
		}

		while (index < s.length() && s.charAt(index) == ' ') {
			index++;
		}

		if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
			if (s.charAt(index) == '-') {
				sign = -1;
			}
			index++;
		}

		while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
			int digit = s.charAt(index) - '0';

			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(index) - '0' > 7)) {
				if (sign == -1) {
					return Integer.MIN_VALUE;
				} else return Integer.MAX_VALUE;
			}

			// adding digits at their desired place-value
			result = (result * 10) + digit;

			++index;
		}

		return result * sign;

	}

	public static String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}

		String maxStr = s.substring(0, 1);

		for (int i = 0; i < s.length() - 1; i++) {
			String odd = expandFromCenter(s, i, i);
			String even = expandFromCenter(s, i, i + 1);

			if (odd.length() > maxStr.length()) {
				maxStr = odd;
			}
			if (even.length() > maxStr.length()) {
				maxStr = even;
			}
		}

		return maxStr;
	}

	private static String expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}


	public static void nextPermutation(int[] nums) {
		int start = -1;
		int end = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				start = i;
				break;
			}
		}

		if (start == -1) {
			reverse(nums, 0);
		} else {
			for (int i = nums.length - 1; i >= 0; i--) {
				if (nums[i] > nums[start]) {
					end = i;
					break;
				}
			}
			swap(nums, start, end);
			// step 3 reverse the rest right half
			reverse(nums, start + 1);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	public static void reverse(int[] nums, int start) {
		int i = start;
		int j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		LinkedList<int[]> list = new LinkedList<>();

		if (intervals.length == 1) {
			list.add(intervals[0]);
			return list.toArray(new int[list.size()][]);
		}

		for (int i = 0; i <= intervals.length - 2; i++) {
			int[] current = intervals[i];
			int[] next = intervals[i + 1];

			if (current[1] >= next[0] || current[0] >= next[1]) {
				int left = Math.min(current[0], next[0]);
				int right = Math.max(current[1], next[1]);
				list.add(new int[]{left, right});
				i++;
			} else {
				list.add(current);
				if (i == intervals.length - 2) {
					list.add(next);
					break;
				}

			}
		}
		return list.toArray(new int[list.size()][]);
	}
}


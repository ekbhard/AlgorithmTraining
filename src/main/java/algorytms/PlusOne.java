package algorytms;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		//https://leetcode.com/problems/plus-one/
		System.out.println(Arrays.toString(plusOne(new int[]{8})));
		System.out.println(Arrays.toString(plusOne(new int[]{9})));
		System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));
		System.out.println(Arrays.toString(plusOne(new int[]{9, 8})));

	}

	public static int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			int[] newArray = new int[1];
			newArray[0] = 1;
			return newArray;
		}

		if (digits.length == 1 && digits[0] + 1 < 10) {
			digits[0] = digits[0] + 1;
			return digits;
		}

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 != 10) {
				digits[i] = digits[i] + 1;
				return digits;
			} else {
				digits[i] = 0;
				if (i == 0) {
					int[] newArray = new int[digits.length + 1];
					newArray[0] = 1;
					for (int j = 0; j < digits.length - 1; j++) {
						newArray[j + 1] = digits[j];
					}
					return newArray;
				}
			}
		}
		return digits;
	}
}

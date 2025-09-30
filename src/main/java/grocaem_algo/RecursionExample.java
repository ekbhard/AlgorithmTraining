package grocaem_algo;

import java.util.Scanner;

public class RecursionExample {


	public static void main(String[] args) {
		counter(5);

		System.out.println(factorial(4));

		System.out.println(sum(new int[]{3, 4, 8}));
	}

	private static void counter(int i) {
		if (i < 0) {
			return;
		} else {
			System.out.println("..." + i + "...");
			counter(i - 1);
		}
	}

	private static int factorial(int i) {
		if (i == 0) return 1;
		return i * factorial(i - 1);
	}

	private static int sum(int[] array) {
		if (array.length == 1) {
			return array[0];
		}
		int[] newArray = new int[array.length - 1];
		for (int i = 1; i < array.length; i++) {
			newArray[i - 1] = array[i];
		}
		return array[0] + sum(newArray);
	}

}

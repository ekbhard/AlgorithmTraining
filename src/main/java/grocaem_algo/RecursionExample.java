package grocaem_algo;

public class RecursionExample {


	public static void main(String[] args) {
		counter(5);

		System.out.println(factorial(4));

		System.out.println(sum(new int[]{3, 4, 8}));

		System.out.println(getBiggestPart(1680, 640));

		System.out.println(recursiveCount(new int[]{5, 8, 4, 3}, 0));
	}

	private static void counter(int i) {
		if (i < 0) {
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

	public static int recursiveCount(int[] array, int index) {
		if (index >= array.length) {
			return 0;
		}
		int i = recursiveCount(array, index + 1);
		return 1 + i;
	}

	public static int getBiggestPart(int m, int n) {
		if (m == n) {
			return m;
		}
		if (m > n) {
			int i = m / n;
			int tempM = m - i * n;
			if (tempM != 0) {
				m = tempM;
			} else {
				m = m - n;
			}
		} else {
			int i = n / m;
			int tempN = n - i * m;
			if (tempN != n) {
				n = tempN;
			} else {
				n = n - m;
			}
		}
		return getBiggestPart(m, n);
	}

}

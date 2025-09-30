package grocaem_algo;

import java.io.*;

public class SelectionSort {

	public int[] selectionSort(int[] array) {

		int length = array.length;
		for (int i = 0; i < length; i++) {

			int minIndex = i;

			for (int j = i + 1; j < length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}

		return array;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("plotInput.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

		String[] parts = br.readLine().split("");
		int first = Integer.parseInt(parts[0]);
		int second = Integer.parseInt(parts[2]);
		pw.println(first + second);
		pw.close();
		br.close();
	}
}

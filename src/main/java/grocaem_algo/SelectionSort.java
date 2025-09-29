package grocaem_algo;

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
}

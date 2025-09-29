package grocaem_algo;

public class BinarySearch {


	/**
	 * Метод бинарного поиска
	 * @param array - массив
	 * @param toFind - число для поиска
	 * @return null если не нашел 
	 */
	public Integer binarySearch(int[] array, int toFind) {
		int low = 0;
		int high = array.length - 1;

		long i = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			int guess = array[mid];
			if (guess > toFind) {
				high = mid - 1;
			} else if (guess < toFind) {
				low = mid + 1;
			} else {
				return array[mid];
			}
			i++;
			System.out.println("Iteration : " + i);
		}
		return null;
	}
}

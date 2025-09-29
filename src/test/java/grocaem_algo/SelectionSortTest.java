package grocaem_algo;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

	public static final SelectionSort sort = new SelectionSort();

	@Test
	public void testSelectionSort1() {
		int[] array = new int[]{1, 23, 2, 7, -5, 0, 56, 9, 345, 90, 2};

		Assert.assertArrayEquals(new int[]{-5, 0, 1, 2, 2, 7, 9, 23, 56, 90, 345}, sort.selectionSort(array));
	}
}

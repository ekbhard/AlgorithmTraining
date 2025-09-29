package grocaem_algo;

import org.junit.Assert;
import org.junit.Test;


public class BinarySearchTest {

	public static final BinarySearch search = new BinarySearch();

	@Test
	public void testBinarySearch1() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer i = search.binarySearch(arr1, 7);

		Assert.assertEquals(Integer.valueOf(7), i);
	}

	@Test
	public void testBinarySearch2() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer i = search.binarySearch(arr1, 100);
		Assert.assertNull(i);

	}

	@Test
	public void testBinarySearch3() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer i = search.binarySearch(arr1, 3);

		Assert.assertEquals(Integer.valueOf(3), i);
	}

	@Test
	public void testBinarySearch4() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer i = search.binarySearch(arr1, 5);

		Assert.assertEquals(Integer.valueOf(5), i);
	}

	@Test
	public void testBinarySearch5() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
		Integer i = search.binarySearch(arr1, 5);

		Assert.assertEquals(Integer.valueOf(5), i);
	}

	@Test
	public void testBinarySearch6() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
		Integer i = search.binarySearch(arr1, 10);

		Assert.assertEquals(Integer.valueOf(10), i);
	}

	@Test
	public void testBinarySearch7() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
		Integer i = search.binarySearch(arr1, 12);

		Assert.assertEquals(Integer.valueOf(12), i);
	}

	@Test
	public void testBinarySearch8() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
		Integer i = search.binarySearch(arr1, 1);

		Assert.assertEquals(Integer.valueOf(1), i);
	}

	@Test
	public void testBinarySearch9() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer i = search.binarySearch(arr1, 1);

		Assert.assertEquals(Integer.valueOf(1), i);
	}

	@Test
	public void testBinarySearch10() {
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer i = search.binarySearch(arr1, 10);

		Assert.assertEquals(Integer.valueOf(10), i);
	}
}

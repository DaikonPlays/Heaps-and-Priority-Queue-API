/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: none
 * 
 * Custom tester to test edge cases. Uses JUnit 
 * to test minheap
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * contains all the test methods.
 */
public class CustomTester {
	
	static void initMinHeap(MyMinHeap<Integer> heap, ArrayList<Integer> data) {
		heap.data = new ArrayList<>(data);
	}
	
	/**
	 * Test the constructor when collections is null
	 */
	@Test
	public void testMyMinHeapConstructor() {
		boolean test = false;
		try{
			MyMinHeap<Integer> minHeap = new MyMinHeap<>(null);
		}
		catch(Exception e) {
			test = true;
		}
		assertTrue(test);

	}

	/**
	 * Test the getMinChildIdx method when both left and right child
	 * are null
	 */
	@Test
	public void testGetMinChildIdx() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {5}
			)
		);
		initMinHeap(heap, arrlist);
		assertEquals(-1, heap.getMinChildIdx(0));
	}

	/**
	 * Test the percolateUp method when index is 0
	 */
	@Test
	public void testPercolateUp() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {1, 2, 3, 4, 5}
			)
		);
		initMinHeap(heap, arrlist);
		heap.percolateUp(0);
		Integer[] fin = {1, 2, 3, 4, 5};
		for (int i = 0; i < arrlist.size(); i++) {
			assertEquals(fin[i],heap.data.get(i));
		}
	}

	/**
	 * Test the percolateDown method when [TODO]
	 */
	@Test
	public void testPercolateDown() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {1, 2, 3, 4, 5}
			)
		);
		initMinHeap(heap, arrlist);
		heap.percolateDown(arrlist.size() - 1);
		Integer[] fin = {1, 2, 3, 4, 5};
		for (int i = 0; i < 5; i++) {
			assertEquals(fin[i], heap.data.get(i));
		}
	}

	/**
	 * Test the deleteIndex method when [TODO]
	 */
	@Test
	public void testDeleteIndex() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {1, 2, 3, 4, 5}
			)
		);
		heap.data = new ArrayList<>(arrlist);
		heap.deleteIndex(arrlist.size() - 1);
		Integer[] fin = {1, 2, 3, 4};
		for (int i = 0; i < arrlist.size() - 1; i++) {
			assertEquals(fin[i], heap.data.get(i));
		}
		assertEquals("size after delete", 4, heap.data.size());
	}

	/**
	 * Test the deleteIndex method when only one element exists
	 */
	@Test
	public void testDeleteIndex2() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {1}
			)
		);
		heap.data = new ArrayList<>(arrlist);
		heap.deleteIndex(0);
		Integer[] fin = {};
		for (int i = 0; i < fin.length; i++) {
			assertEquals(fin[i], heap.data.get(i));
		}
		assertEquals("size after delete", 0, heap.data.size());
	}

	/**
	 * Test the insert method when element is null
	 */
	@Test
	public void testInsert(){
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {1, 2, 3}
			)
		);
		boolean test = false;
		initMinHeap(heap, arrList);
		try{
			heap.insert(null);
		}
		catch(Exception e) {
			test = true;
		}
		assertTrue(test);
	}

	/**
	 * Test the insert method when element exists at the end
	 */
	@Test
	public void testInsert2(){
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> arrList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] {1, 2, 3}
			)
		);
		initMinHeap(heap, arrList);
		heap.insert(3);
		Integer[] fin = {1, 2, 3, 3};
		for (int i = 0; i < 4; i++) {
			assertEquals(fin[i], heap.data.get(i));
		}

	}

   
	/**
	 * Test remove when size is 0
	 */
	@Test
	public void testRemove(){
		MyMinHeap<Integer> heap = new MyMinHeap<>(); 
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[]{}
			)
		);
		heap.data = new ArrayList<>(arrlist);
		assertNull(heap.remove());
	}

  
	/**
	 * Test getMin when size is 0
	 */
	@Test
	public void testGetMin(){
		MyMinHeap<Integer> heap = new MyMinHeap<>(); 
		ArrayList<Integer> arrlist = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[]{}
			)
		);
		heap.data = new ArrayList<>(arrlist);
		assertNull(heap.getMin());
	}
}
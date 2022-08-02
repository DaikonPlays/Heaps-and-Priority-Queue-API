/**
 * TODO: Add your file header
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: None
 * 
 * Priority queue api. Contains al the methods
 * needed to run the api
 */

import java.util.Collection;

/**
 * class with the methods to run priority queue.
 * Instance variable:
 * heap, minheap type 
 */
public class MyPriorityQueue<E extends Comparable<E>>
{

	//TODO: Add a public instance variable called "heap"
	//"heap" is of a generic MyMinHeap type
    public MyMinHeap<E> heap = new MyMinHeap<E>();
	
	/**
	 * Constructor that creates an empty priority queue
	 */
	public MyPriorityQueue(){
		heap = new MyMinHeap<>();
	}

	/**
	 * Constructor that creates a priority queue from a collection
	 * @param collection The collection used to intialize priority queue
	 */
	public MyPriorityQueue(Collection<? extends E> collection){
		heap = new MyMinHeap<>(collection);
	}

	/**
	 * Adds an element to the priority queue
	 * @param element the element to be added
	 */
	public void push(E element){
		heap.insert(element);
	}

	/**
	 * Removes the element with the highest priority from the priority queue 
	 * @return the element with the highest priority
	 */
	public E pop(){
		return heap.remove();
	}

	/**
	 * Sees the element with the highest priority from the priority queue
	 * @return the element with the highest priority
	 */
	public E peek(){
		return heap.getMin();
	}

	/**
	 * Finds the number of elements in the priority queue
	 * @return the number of elements in the priority queue
	 */
	public int getLength(){
		return heap.size();
	}

	/**
	 * Remove all the elements from the priority queue.
	 */
	public void clear(){
		heap.clear();
	}
}
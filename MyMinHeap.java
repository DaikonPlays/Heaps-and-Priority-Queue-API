import java.util.ArrayList;
import java.util.Collection;

/**
 * Name: Kevin Yan
 * Email: kevinyan904@gmail.com
 * Sources used: Tutors, zybooks
 * 
 * This is a minheap file. It has minheap api.
 * 
 */

// Your import statements

/**
 * Contains all the methods for the minheap api
 * Instance variable: 
 * data, ArrayList containing heap
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{
    public ArrayList<E> data;

    public MyMinHeap(){
        data = new ArrayList<E>();
    }
	public MyMinHeap(Collection<? extends E> collection) {
		if(collection == null || collection.contains(null)) {
            throw new NullPointerException();
        }
		data = new ArrayList(collection);
		//iterates down data to percolateDown
		for(int i = data.size() - 1; i >= 0; i--){
			percolateDown(i);
		}
	}
	/**
	 * swaps the element from first index to the next
	 * @param from starting index to swap
	 * @param to end index to swap
	 */
	protected void swap(int from, int to) {
		E elefrom = data.get(from);
		E eleto = data.get(to);
		data.set(from, eleto);
		data.set(to, elefrom);
	}
	/**
	 * returns the index of parent 
	 * @param index of the element 
	 * @return index of parent index
	 */
	protected int getParentIdx(int index) {
		return (index - 1) / 2;
	}
	/**
	 * returns the left child index
	 * @param index of element
	 * @return left child index
	 */
	protected int getLeftChildIdx(int index) {
		return (2 * index) + 1;
	}
	/**
	 * return the right child index
	 * @param index of the element
	 * @return right child index
	 */
	protected int getRightChildIdx(int index) {
		return (2 * index) + 2;
	}
	/**
	 * returns the smallest child index
	 * @param index of element
	 * @return index of smallest child
	 */
	protected int getMinChildIdx(int index) {
		E leftChild = null;
		E rightChild = null;
		//checks if left child is valid
		if(getLeftChildIdx(index) < data.size() && getLeftChildIdx(index) >= 0){
			leftChild = data.get(getLeftChildIdx(index));
		}
		//checks if right child is valid
		if(getRightChildIdx(index) < data.size() && getRightChildIdx(index) >= 0){
			rightChild = data.get(getRightChildIdx(index));
		}
		//checks if there are no children
		if(leftChild == null && rightChild == null){
			return -1;
		}
		//checks if there are no children
		if(leftChild != null && rightChild == null) {
			return getLeftChildIdx(index);
		}
		//checks if left and right child are equal and if there is no right child
		if(data.get(getLeftChildIdx(index)) == data.get(getRightChildIdx(index)) ||
		rightChild == null) {
			return getLeftChildIdx(index);
		}
		//checks if right is less than left or if left is null
		if(data.get(getLeftChildIdx(index)).compareTo(data.get(getRightChildIdx(index))) > 0
		|| leftChild == null) {
			return getRightChildIdx(index); 
		}
		//checks if right is more than left
		if(data.get(getLeftChildIdx(index)).compareTo(data.get(getRightChildIdx(index))) < 0) {
			return getLeftChildIdx(index); 
		}
		else{
			return -1;
		}
	}
	protected void percolateUp(int index) {
		while(index > 0) {
			//saves parent index
			int parentInd = getParentIdx(index);
			//checks if the data at index is greater than parent
			if(data.get(index).compareTo(data.get(parentInd)) >= 0) {
				return;
			}
			else{
				//swaps index and parentInd
				swap(index, parentInd);
				index = parentInd;
			}
		}
	}
	protected void percolateDown(int index) {
		//saves smallest child 
		int smallest = getMinChildIdx(index);
		//makes sure smallest is valid and starts while loop
		while(smallest != -1 && data.get(index).compareTo(data.get(smallest)) > 0) {
				swap(index, smallest);
				index = smallest;
				smallest = getMinChildIdx(index);
		}
	}
	protected E deleteIndex(int index) {
		E removed = data.get(index);
		E swap = data.remove(data.size() - 1);
		//removes the E at index 
		if(data.size() != index) {
			data.set(index, swap);
			percolateDown(index);
			percolateUp(index);
		}
		
		return removed;
		
	}
	@Override
	public void insert(E element) {
		if(element == null) {
			throw new NullPointerException();
		}
		data.add(element);
		percolateUp(data.size() - 1);
	}

	@Override
	public E getMin() {
		if(data.size() == 0) {
			return null;
		}
		else{
			return data.get(0);
		}
	}

	@Override
	public E remove() {
		if(data.size() == 0){
            return null;
        }
		E removed = data.get(0);
		//removes at index 0
        deleteIndex(0);
        return removed;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public void clear() {
		data.clear();		
	}

}
package PriorityQueue;

import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> implements Iterable<E> {
	ArrayList<E> data;

	public PriorityQueue() {
		data = new ArrayList<>();
	}

//Highest priority is given to minimum element
	/**
	 * Add element in the list*
	 * 
	 * @param value
	 */
	public void enqueue(E value) {
		data.add(value);
		upheapify(data.size() - 1);

	}

	private void upheapify(int index) {
		if (index == 0)
			return;
		int parentIndex = (index - 1) / 2;
		if ((data.get(parentIndex).compareTo(data.get(index))) > 0) {
			swap(parentIndex, index);
			upheapify(parentIndex);
		}
	}

	private void swap(int firstIndex, int secondIndex) {
		E parentData = data.get(firstIndex);
		E childData = data.get(secondIndex);
		data.set(secondIndex, parentData);
		data.set(firstIndex, childData);
	}

	/**
	 * Removes and returns the highest priority element from this list.
	 * 
	 * @return
	 * @throws Exception
	 */
	public E dequeue() throws Exception {
		if (data.size() == 0) {
			throw new Exception("Priority Queue is Underflow");
		}
		swap(0, data.size() - 1);
		E removeData = data.remove(data.size() - 1);
		downheapify(0);
		return removeData;
	}

	private void downheapify(int parentIndex) {
		int minIndex = parentIndex;
		int leftChildIndex = 2 * parentIndex + 1;
		if (leftChildIndex < data.size() && (data.get(leftChildIndex).compareTo(data.get(minIndex))) < 0) {
			minIndex = leftChildIndex;
		}
		int rightChildIndex = 2 * parentIndex + 2;
		if (rightChildIndex < data.size() && (data.get(rightChildIndex).compareTo(data.get(minIndex))) < 0) {
			minIndex = rightChildIndex;
		}
		if (minIndex != parentIndex) {
			swap(minIndex, parentIndex);
			downheapify(minIndex);
		}
	}

	/**
	 * Returns the highest priority element from this list.
	 * 
	 * @return
	 * @throws Exception
	 */
	public E peek() throws Exception {
		if (data.size() == 0) {
			throw new Exception("Priority Queue is Empty");
		}
		return data.get(0);
	}

	/**
	 * This method check the element is present or not. *
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(E value) {
		for (E val : data) {
			if (val.equals(value))
				return true;
		}
		return false;

	}

	/*
	 * Returns the size of the list.
	 */
	public int size() {
		return data.size();
	}

	public void reverse() {
		int leftPointer = 0, rightPointer = data.size() - 1;
		while (leftPointer < rightPointer) {
			swap(leftPointer, rightPointer);
			leftPointer++;
			rightPointer--;
		}
	}

	/*
	 * Method used to iterate over list.
	 */
	public Iterator<E> iterator() {
		return new myIterator();
	}

	private class myIterator implements Iterator<E> {

		private int index = 0;

		public boolean hasNext() {
			return index < size();
		}

		public E next() {
			return data.get(index++);

		}
	}

}

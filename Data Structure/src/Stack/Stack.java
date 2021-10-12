package Stack;

import java.util.Iterator;

public class Stack<E> implements Iterable<E> {
	E[] data;
	int topOfStack;

	public Stack() {
		data = (E[]) new Object[5];
		topOfStack = -1;
	}

	public Stack(int capacity) {
		data = (E[]) new Object[capacity];
		topOfStack = -1;
	}

	/**
	 * Inserts element at the last in this list.
	 * 
	 * @param value
	 */
	public void push(E value) {
		if (topOfStack == data.length - 1) {
			increaseCapacity();
		}
		topOfStack++;
		data[topOfStack] = value;
	}

	private void increaseCapacity() {
		E[] newData = (E[]) new Object[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * Removes and returns the last element from this list.
	 * 
	 * @return
	 * @throws Exception
	 */
	public E pop() throws Exception {

		if (topOfStack == -1) {
			throw new Exception("Stack is Empty");
		}
		E value = data[topOfStack];
		topOfStack--;
		return value;
	}

	/**
	 * Returns last element from this list.
	 * 
	 * @return
	 * @throws Exception
	 */
	public E peek() throws Exception {
		if (topOfStack == -1) {
			throw new Exception("Stack is Empty");
		}
		return data[topOfStack];
	}

	/**
	 * This method is check element is present or not*
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public boolean contains(E value) throws Exception {
		if (topOfStack == -1) {
			throw new Exception("Stack is Empty");
		}
		for (int i = 0; i <= topOfStack; i++) {
			if (data[i] == value)
				return true;
		}
		return false;
	}

	/**
	 * Returns the size of the list.
	 * 
	 * @return
	 */
	public int size() {

		return topOfStack + 1;
	}

	/**
	 * This method reverse the list.*
	 * 
	 * @throws Exception
	 */
	public void reverse() throws Exception {
		int leftPointer = 0, rightPointer = topOfStack;
		while (leftPointer < rightPointer) {
			E t = data[leftPointer];
			data[leftPointer] = data[rightPointer];
			data[rightPointer] = t;
			leftPointer++;
			rightPointer--;
		}
	}

	/**
	 * This method is used to iterate over list.
	 */
	public Iterator<E> iterator() {

		return new myIterator();
	}

	public void print() {
		System.out.println("-----------------------------------");
		for (int i = topOfStack; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.println("\n----------------------------------------------");
	}

	private class myIterator implements Iterator<E> {

		private int index = size() - 1;

		public boolean hasNext() {
			return index >= 0;
		}

		public E next() {
			return (E) data[index--];
		}
	}

}

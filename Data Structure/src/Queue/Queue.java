package Queue;

import java.util.Iterator;

public class Queue<E> implements Iterable<E> {
	private E[] data;
	private int front;
	private int size;

	public Queue() {
		data = (E[]) new Object[5];
		front = size = 0;
	}

	public Queue(int capacity) {
		data = (E[]) new Object[capacity];
		front = size = 0;
	}

	/**
	 * this method is used to insert data in queue*
	 * 
	 * @param value
	 */

	public void enqueue(E value) {
		if (size() == data.length) {
			increaseCapacity();
		}
		int idx = (front + size) % data.length;
		data[idx] = value;
		size++;
	}

	private void increaseCapacity() {
		E[] newDataQueue = (E[]) new Object[data.length * 2];
		for (int i = 0; i < size(); i++) {
			int idx = (i + front) % data.length;
			newDataQueue[i] = data[idx];
		}
		front = 0;
		data = newDataQueue;
	}

	/**
	 * Removes and returns the element from this list.*
	 * 
	 * @return
	 * @throws Exception
	 */
	public E dequeue() throws Exception {
		if (size == 0)
			throw new Exception("Queue is Empty");
		E temp = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return temp;
	}

/*
 * this method returns the top element of a list
 */
	public E peek() throws Exception {
		if (size == 0)
			throw new Exception("Queue is Empty");
		return data[front];
	}

	/**
	 * this method is used to check the data is present or not*
	 * 
	 * @param value
	 * @return
	 */
	public boolean contains(E value) {
		int index = front;
		int currentSize = size;
		while (currentSize != 0) {
			if (data[index % data.length].equals(value))
				return true;
			currentSize--;
		}
		return false;
	}

	/**
	 * Return the size of a list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/*
	 * This method reverse the list
	 */
	public void reverse() {
		int rightPointer = (front + size - 1) % data.length;
		int leftPointer = front;
		while (leftPointer != rightPointer) {
			E temp = data[leftPointer];
			data[leftPointer] = data[rightPointer];
			data[rightPointer] = temp;
			leftPointer = (leftPointer + 1) % data.length;
			rightPointer = (rightPointer - 1 + data.length) % data.length;
		}
	}

	/**
	 * this method is to print the list
	 */
	public void print() {
		System.out.println("--------------------------");
		for (int i = 0; i < size(); i++) {
			int idx = (i + front) % data.length;
			System.out.print(data[idx] + " ");
		}
		System.out.println("\n------------------------");
	}

	/**
	 * this is used to iterate on a list
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
			E val = data[(index + front) % data.length];
			index++;
			return val;

		}
	}
}

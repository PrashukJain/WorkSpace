package LinkedList;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
	private class Node {
		public E data;
		Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Inserts element at the last in this list.
	 * 
	 * @param data data to be inserted
	 */
	public void insert(E data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;

	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index index at which the specified element is to be inserted
	 * @param data  data to be inserted
	 * @throws Exception Invalid position
	 */
	public void insertAt(int index, E data) throws Exception {
		if (index < 0 || index > size) {
			throw new Exception("Invalid position");
		}
		if (index == 0) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			size++;
		} else if (index == size) {
			insert(data);
		} else {

			Node prevListNode = getNodeAt(index - 1);
			Node newNode = new Node(data);
			newNode.next = prevListNode.next;
			prevListNode.next = newNode;
			size++;
		}

	}

	/**
	 * Removes and returns the last element from this list.
	 * 
	 * @return the last element from this list
	 * @throws Exception LinkedList is Empty
	 */
	public E delete() throws Exception {
		if (size == 0) {
			throw new Exception("LinkedList is Empty");
		}
		E temp = (E) tail.data;
		if (size == 1) {
			head = tail = null;
		} else {
			tail = getNodeAt(size - 2);

			tail.next = null;
		}
		size--;
		return temp;

	}

	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param position the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws Exception LinkedList is Empty Invalid position
	 */
	public E deleteAt(int position) throws Exception {
		if (size == 0) {
			throw new Exception("LinkedList is Empty");
		}
		if (position < 0 || position >= size) {
			throw new Exception("Invalid position");
		}
		if (position == size - 1) {
			return delete();
		} else if (position == 0) {
			E temp = (E) head.data;
			head = head.next;
			if (size == 1)
				tail = null;
			size--;
			return temp;
		} else {
			Node prevNodeofDelteN = getNodeAt(position - 1);
			Node deleteNode = prevNodeofDelteN.next;
			prevNodeofDelteN.next = deleteNode.next;
			size--;
			return (E) deleteNode.data;
		}

	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param position index of the element to return
	 * 
	 * @return the element at the specified position in this list
	 */

	public Node getNodeAt(int position) {
		int index = 0;
		Node current = head;
		while (index < position) {
			current = current.next;
			index++;
		}
		return current;
	}

	/**
	 * Returns the element at the center position in this list.
	 * 
	 * @return the element at the center position in this list
	 * @throws Exception
	 */
	public E center() throws Exception {
		if (size == 0) {
			throw new Exception("LinkedList is Empty");
		}
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return (E) slow.data;
	}

	/**
	 * This method reverse the list
	 * 
	 * @throws Exception LinkedList is Empty
	 */
	public void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("LinkedList is Empty");
		}
		Node prev = null, curr = head, temp;
		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		temp = head;
		head = tail;
		tail = temp;

	}

	/**
	 * Returns size of the list *
	 * 
	 * @return integer
	 */
	public int size() {
		return this.size;
	}

	/**
	 * this method is used to print list
	 */
	public void print() {
		System.out.println("-----------------------------");
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println("\n-----------------------------");
	}

	/**
	 * this is used to iterate on a list
	 */
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

		private int index = 0;

		public boolean hasNext() {
			return index < size();
		}

		public E next() {
			return (E) getNodeAt(index++).data;
		}
	}

}

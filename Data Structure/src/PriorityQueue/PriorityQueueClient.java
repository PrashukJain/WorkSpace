package PriorityQueue;

import java.util.Iterator;

public class PriorityQueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PriorityQueue pq = new PriorityQueue();
		pq.enqueue(10);
		pq.enqueue(20);
		pq.enqueue(30);
		pq.enqueue(40);
		Iterator<Integer> itr = pq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println(pq.peek());
		System.out.println(pq.dequeue());
		itr = pq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println(pq.dequeue());
		System.out.println(pq.peek());
		itr = pq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
}

	}

}

package Queue;

import java.util.Iterator;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue<Integer> q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.print();

		System.out.println(q.peek());
		System.out.println(q.size());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.print();
		q.enqueue(5);
		Iterator<Integer> itr = q.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		q.dequeue();
		q.dequeue();
		q.print();
		q.enqueue(4);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		itr = q.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		q.print();
		System.out.println(q.size());
		q.reverse();
		q.print();
		System.out.println(q.size());
		itr = q.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}

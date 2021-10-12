package LinkedList;

import java.util.Iterator;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<>();
		ll.insert("10");
		ll.insert("20");
		System.out.println(ll.size());
		ll.print();
		ll.insertAt(0, "5");
		System.out.println(ll.size());
		ll.print();
		ll.insertAt(2, "15");
		ll.insertAt(4, "30");
		Iterator<String> itr = ll.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println("\n" + ll.size());
		ll.print();
		System.out.println(ll.center());
		ll.reverse();
		ll.delete();
		System.out.println(ll.size());
		ll.print();

		ll.reverse();
		System.out.println(ll.size());
		ll.print();
		ll.deleteAt(3);
		ll.deleteAt(1);
		ll.print();
		ll.print();
//		
	}

}

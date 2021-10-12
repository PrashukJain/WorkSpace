package HashTable;

import java.util.Iterator;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String, Integer> ht = new HashTable<>();
		ht.insert("India", 1);
		ht.insert("USA", 2);
		ht.insert("Uk", 3);
		ht.insert("Ukraine", 4);
		ht.insert("Germany", 5);
		ht.print();
		ht.insert("Pakistan", 6);
		ht.insert("China", 7);
		ht.insert("Indonesia", 8);
		ht.insert("Bangladesh", 9);
		ht.insert("China", 10);
		ht.print();
		System.out.println(ht.size());
		ht.delete("Pakistan");
		ht.print();
		System.out.println(ht.size());
		ht.delete("Pakistan");
		System.out.println(ht.contains("Pakistan"));
		System.out.println(ht.contains("India"));
		System.out.println(ht.contains("USA"));
		System.out.println(ht.getValueByKey("USA"));
		Iterator<Object> itr = ht.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());

		}
	}

}

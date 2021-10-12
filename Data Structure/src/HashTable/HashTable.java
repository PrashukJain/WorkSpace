package HashTable;

import java.util.ArrayList;
import java.util.Iterator;

import LinkedList.LinkedList;

public class HashTable<K, V> {
	private class HashTableNode<K, V> {
		K key;
		V value;

		public HashTableNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private int size; // n
	private LinkedList<HashTableNode>[] buckets; // N = buckets.length

	public HashTable() {
		initbuckets(5);
		size = 0;
	}

	private void initbuckets(int N) {
		buckets = new LinkedList[N];
		for (int bi = 0; bi < buckets.length; bi++) {
			buckets[bi] = new LinkedList<>();
		}
	}

	/*
	 * Insert the key and value in a table.
	 */
	public void insert(K key, V value) {
		if (value == null) {
			throw new NullPointerException();
		}
		int bucketIndex = HashFunction(key);
		int keyIndex = getIndexinBucket(key, bucketIndex);

		if (keyIndex != -1) {
			LinkedList<HashTableNode> bucketList = buckets[bucketIndex];
			HashTableNode node = getNodeAt(bucketList, keyIndex);
			node.value = value;

		} else {
			HashTableNode node = new HashTableNode(key, value);
			buckets[bucketIndex].insert(node);
			size++;
		}
		double lambda = size * 1.0 / buckets.length;
		if (lambda > 0.75) {
			rehashing();
		}

	}

	/*
	 * Check this key is present or not in a table and returns boolean value.
	 */
	public boolean contains(K key) {
		int bucketIndex = HashFunction(key);
		int keyIndex = getIndexinBucket(key, bucketIndex);

		if (keyIndex != -1) {
			return true;
		}
		return false;
	}

	/*
	 * Removes and Returns the value from a table
	 */
	public V delete(K key) throws Exception {
		int bucketIndex = HashFunction(key);
		int keyIndex = getIndexinBucket(key, bucketIndex);
		if (keyIndex != -1) {
			LinkedList<HashTableNode> bucketList = buckets[bucketIndex];
			HashTableNode node = bucketList.deleteAt(keyIndex);
			size--;
			return (V) node.value;

		}
		return null;
	}

	/*
	 * Return the value of a given key.
	 */
	public V getValueByKey(K key) throws Exception {
		int bucketIndex = HashFunction(key);
		int keyIndex = getIndexinBucket(key, bucketIndex);

		if (keyIndex != -1) {
			LinkedList<HashTableNode> bucketList = buckets[bucketIndex];
			HashTableNode node = getNodeAt(bucketList, keyIndex);
			return (V) node.value;

		} else {
			throw new Exception("Key is not present");

		}
	}

	/*
	 * Returns the size of a table
	 */
	public int size() {
		return size;
	}

	/*
	 * This method is used to iterate on a list.
	 */
	public Iterator<Object> iterator() {
		return new myIterator();
	}

	public void print() {
		System.out.println("--------------------------------");
		for (int i = 0; i < buckets.length; i++) {
			for (HashTableNode node : buckets[i]) {
				System.out.println(node.key + "->" + node.value);
			}
		}
		System.out.println("----------------------------------");
	}

	/*
	 * This method returns the key value list.
	 */
	public ArrayList<HashTableNode> keyValueSet() {
		if (size == 0)
			return new ArrayList<>();
		ArrayList<HashTableNode> keyValueSet = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (HashTableNode node : buckets[i]) {
				keyValueSet.add(node);
			}
		}
		return keyValueSet;
	}

	/*
	 * This method returns the key list
	 */
	public ArrayList<K> keySet() {
		if (size == 0)
			return new ArrayList<>();
		ArrayList<K> keySet = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (HashTableNode node : buckets[i]) {
				keySet.add((K) node.key);
			}
		}
		return keySet;

	}

	/*
	 * This method returns the values list
	 */
	public ArrayList<V> values() {
		if (size == 0)
			return new ArrayList<>();
		ArrayList<V> valueSet = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (HashTableNode node : buckets[i]) {
				valueSet.add((V) node.value);
			}
		}
		return valueSet;
	}

	private int HashFunction(K key) {
		int HashCode = key.hashCode();
		return Math.abs(HashCode) % buckets.length;
	}

	private int getIndexinBucket(K key, int bi) {
		int keyIndex = 0;
		for (HashTableNode node : buckets[bi]) {
			if (node.key.equals(key))
				return keyIndex;
			keyIndex++;
		}
		return -1;

	}

	private void rehashing() {
		LinkedList<HashTableNode>[] oldHashTable = buckets;
		initbuckets(oldHashTable.length * 2);
		size = 0;
		for (int i = 0; i < oldHashTable.length; i++) {
			for (HashTableNode node : oldHashTable[i]) {
				insert((K) node.key, (V) node.value);
			}
		}
	}

	private HashTableNode getNodeAt(LinkedList<HashTableNode> bucketList, int position) {
		int index = 0;
		HashTableNode current = null;

		for (HashTableNode node : bucketList) {
			current = node;

			if (index == position) {
				break;
			}
			index++;
		}
		return current;
	}

	private class myIterator implements Iterator<Object> {

		private int index = 0;

		public boolean hasNext() {
			return index < size();
		}

		public Object next() {
			String output = "";
			ArrayList<HashTableNode> keyValueSet = keyValueSet();
			output += "Key: " + keyValueSet.get(index).key + " :: Value:" + keyValueSet.get(index).value;
			index++;
			return output;
		}
	}

}

package NChildTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import LinkedList.LinkedList;

public class NChildTree<E> {
	private class TreeNode<E> {
		E value;
		int id;
		ArrayList<TreeNode> children = new ArrayList<>();

		TreeNode(E value, int id) {
			this.value = value;
			this.id = id;
		}
	}

	private TreeNode root;

	private HashSet<Integer> idSet;

	public NChildTree() {
		idSet = new HashSet<>();
	}
	/*
	 * This method used to enter root data of a tree.
	 */

	public void insert(E value, int id) throws Exception {

		if (root == null) {
			root = new TreeNode(value, id);
			idSet.add(id);
		} else {
			throw new Exception("Cannot create element at top of root");
		}
	}

	/*
	 * This method is used to insert element in a tree.
	 */
	public void insert(int parentId, E data, int id) throws Exception {
		if (!idSet.isEmpty() && idSet.contains(id))
			throw new Exception("Tree Cannot contain Duplicate Id's");
		if (!idSet.contains(parentId))
			throw new Error("No Parent Found");
		if (root.id == parentId)
			root.children.add(new TreeNode<E>(data, id));
		else
			insert(parentId, data, root, id);
		idSet.add(id);
	}

	private void insert(int parentId, E value, TreeNode node, int id) {
		for (int i = 0; i < node.children.size(); i++) {
			TreeNode childofParent = (TreeNode) node.children.get(i);
			if (childofParent.id == parentId) {
				childofParent.children.add(new TreeNode(value, id));
				return;
			} else {
				insert(parentId, value, childofParent, id);
			}
		}
	}

	/*
	 * This method is used to check the elements is present or not.
	 */
	public boolean contains(E value) {
		return contains(root, value);
	}

	private boolean contains(TreeNode node, E value) {
		if (node == null)
			return false;
		if (node.value.equals(value))
			return true;
		for (int i = 0; i < node.children.size(); i++) {
			TreeNode childofParent = (TreeNode) node.children.get(i);
			if (contains(childofParent, value))
				return true;
		}
		return false;
	}

	/*
	 * This method is used to delete the element from a tree by value.
	 */
	public void deleteByValue(E value) {
		if (root.value.equals(value)) {
			root = null;
			return;
		}
		delete(root, value);
	}

	private void delete(TreeNode parent, E value) {

		for (int i = 0; i < parent.children.size(); i++) {
			TreeNode childofParent = (TreeNode) parent.children.get(i);
			if (childofParent.value.equals(value)) {
				parent.children.remove(childofParent);
				return;
			} else {
				delete(childofParent, value);
			}
		}
	}
	/*
	 * This method is used to delete the element from a tree by id.
	 */

	public void deleteById(int deleteId) {
		if (!idSet.contains(deleteId))
			return;
		if (root.id == deleteId) {
			root = null;
			return;
		}
		delete(root, deleteId);
	}

	private void delete(TreeNode parent, int deleteId) {

		for (int i = 0; i < parent.children.size(); i++) {
			TreeNode childofParent = (TreeNode) parent.children.get(i);
			if (childofParent.id == deleteId) {
				parent.children.remove(childofParent);
				return;
			} else {
				delete(childofParent, deleteId);
			}
		}
	}

	/*
	 * This method is used to get the element from a tree by value.
	 */
	public String getElementsByValue(E value) {
		ArrayList<TreeNode> result = getElementsByValue(root, value);
		StringBuilder sb = new StringBuilder();
		for (TreeNode node : result)
			sb.append(node.value + " ");
		return sb.toString();

	}

	private ArrayList<TreeNode> getElementsByValue(TreeNode node, E value) {
		ArrayList<TreeNode> result = new ArrayList<>();
		if (node.value.equals(value)) {
			result.add(node);
		}

		for (int i = 0; i < node.children.size(); i++) {
			ArrayList<TreeNode> mr = getElementsByValue((TreeNode) node.children.get(i), value);
			for (TreeNode RecNode : mr) {
				result.add(RecNode);
			}
		}
		return result;

	}

	/*
	 * This method is used to get the element from a tree by level.
	 */
	public String getElementsByLevel(int level) throws Exception {
		ArrayList<TreeNode> result = getElementsByLevelWise(level);
		StringBuilder sb = new StringBuilder();
		for (TreeNode node : result)
			sb.append(node.value + " ");
		return sb.toString();
	}

	private ArrayList<TreeNode> getElementsByLevelWise(int level) throws Exception {
		int initLevel = 0;
		LinkedList<TreeNode> list = new LinkedList<>();
		list.insert(root);
		while (initLevel < level - 1 && list.size() > 0) {
			TreeNode node = list.deleteAt(0);
			if (node == null) {
				list.insert(null);
				initLevel++;
				continue;
			}
			for (int i = 0; i < node.children.size(); i++) {
				list.insert((TreeNode) node.children.get(i));
			}
		}
		ArrayList<TreeNode> result = new ArrayList<>();
		for (TreeNode levelNode : list) {
			if (levelNode == null)
				break;
			result.add(levelNode);
		}
		return result;
	}

	/*
	 * This method is used to print the element of a tree in Breadth First manner.
	 */
	public void printBreadthFirst() throws Exception {
		if (root == null)
			return;
		ArrayList<E> list = printBreadthFirst1();
		for (E node : list)
			System.out.print(node + " ");
		System.out.println();
	}

	private ArrayList<E> printBreadthFirst1() throws Exception {
		if (root == null)
			return new ArrayList<>();
		LinkedList<TreeNode> list = new LinkedList<>();
		list.insert(root);
		ArrayList<E> resultList = new ArrayList<>();
		while (list.size() > 0) {
			TreeNode node = list.deleteAt(0);
			for (int i = 0; i < node.children.size(); i++) {
				list.insert((TreeNode) node.children.get(i));
			}

			resultList.add((E) node.value);
		}
		System.out.println();
		return resultList;
	}

	/*
	 * This method is used to print the element of a tree in Depth First manner.
	 */
	public void printDepthFirst() throws Exception {
		if (root == null)
			return;
		ArrayList<E> list = printDepthFirst1();
		for (E node : list)
			System.out.print(node + " ");
		System.out.println();
	}

	private ArrayList<E> printDepthFirst1() throws Exception {
		if (root == null)
			return new ArrayList<>();
		LinkedList<TreeNode> list = new LinkedList<>();
		ArrayList<E> resultList = new ArrayList<>();
		list.insert(root);
		while (list.size() > 0) {
			TreeNode node = list.delete();
			for (int i = 0; i < node.children.size(); i++) {
				list.insert((TreeNode) node.children.get(i));
			}

			resultList.add((E) node.value);
		}
		// System.out.println();
		return resultList;

	}
	/*
	 * This method is used to display the elements of a tree.
	 */

	public void display() {
		System.out.println("-------------------------");
		display(root);
		System.out.println("-------------------------");
	}

	private void display(TreeNode node) {
		System.out.print(node.value + " -> ");
		for (int i = 0; i < node.children.size(); i++) {
			TreeNode childNode = (TreeNode) node.children.get(i);
			System.out.print(childNode.value + ", ");
		}
		System.out.println("..");
		for (int i = 0; i < node.children.size(); i++) {
			display((TreeNode) node.children.get(i));
		}

	}

	/**
	 * Iterate on a tree
	 */

	public Iterator<E> iterator(String type) throws Exception {

		if (type.equals("bfs"))
			return new myIteratorbfs();
		else if (type.equals("dfs"))
			return new myIteratordfs();
		else
			throw new Exception("Invalid Type");

	}

	private class myIteratorbfs<E> implements Iterator<E> {
		private int index = -1;
		private ArrayList<E> bfsList;

		public myIteratorbfs() throws Exception {
			bfsList = (ArrayList<E>) printBreadthFirst1();
		}

		public boolean hasNext() {
			return index < bfsList.size() - 1;
		}

		public E next() {
			index++;
			return bfsList.get(index);
		}

	}

	private class myIteratordfs<E> implements Iterator<E> {
		private int index = -1;
		private ArrayList<E> dfsList;

		public myIteratordfs() throws Exception {
			dfsList = (ArrayList<E>) printDepthFirst1();
		}

		public boolean hasNext() {
			return index < dfsList.size() - 1;
		}

		public E next() {
			index++;
			return dfsList.get(index);
		}

	}

}
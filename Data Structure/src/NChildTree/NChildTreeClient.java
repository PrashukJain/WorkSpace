package NChildTree;

import java.util.Iterator;

public class NChildTreeClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		NChildTree<String> tree = new NChildTree();

		tree.insert("Folder", 0);
		tree.insert(0, "Folder1", 1);
		tree.insert(0, "Folder2", 2);
		tree.insert(0, "Folder3", 3);
		tree.insert(0, "Folder4", 4);
		tree.insert(0, "Folder5", 5);
		tree.insert(0, "Folder6", 6);
		tree.insert(1, "subFodler11", 11);
		tree.insert(2, "subFolder21", 21);
		tree.insert(3, "subFodler31", 31);
		tree.insert(4, "subFolder41", 41);
		tree.insert(5, "subFodler51", 51);
		tree.insert(6, "subFolder61", 61);
		tree.insert(41, "subFodler411", 411);
		tree.insert(41, "subFolder412", 412);
		tree.insert(412, "subFodler4121", 4121);
		tree.insert(412, "subFolder4122", 4122);
		tree.display();
		tree.deleteById(1);
		tree.printBreadthFirst();
		System.out.println(tree.getElementsByValue("Folder"));
		System.out.println(tree.contains("Folder"));
		Iterator<String> itr = tree.iterator("bfs");
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
		System.out.println("----------------------------");
		itr = tree.iterator("dfs");
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
	}

}

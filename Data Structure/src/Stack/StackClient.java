package Stack;

import java.util.Iterator;

public class StackClient {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
		Stack<String> st = new Stack();
		st.push("10");
		st.push("20");
		st.push("30");
		st.push("40");
		st.push("50");
		System.out.println(st.pop());
		System.out.println(st.pop());
		st.print();
		System.out.println(st.contains("40"));
		st.reverse();
		st.print();
		Iterator<String> itr = st.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

    }

}

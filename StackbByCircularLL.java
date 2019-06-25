
//-----------------------------------------------------
// Description: This class defines a String stack by using circular linked-list
//-----------------------------------------------------
import java.util.Iterator;
import java.util.*;

public class StackbByCircularLL implements Iterable<String> {

	// save the number of items in the stack ,first node and last node.
	int numberOfitem = 0;
	private Node first = null;
	private Node last = null;

	// saves the string in item and the next node to link them.
	public class Node {
		Node next;

		String item;

		public Node(String item)
		// --------------------------------------------------------
		// Summary: add String to the item in the node
		// Precondition: item is a String
		// --------------------------------------------------------
		{
			this.item = item;
			next = null;

		}

	}

	public void push(String item)

	// --------------------------------------------------------
	// Summary: add iem to the stack
	// Precondition: item is a String
	// --------------------------------------------------------
	{
		// point first node by using oldfirst
		Node oldfirst = first;

		// create a node and add item to it and point old first by using next in
		// the first node. by doing that we linked them.
		first = new Node(item);
		first.next = oldfirst;
		// if stack is empty first node is also the last node.
		if (this.isEmpty()) {
			last = first;

		}
		// this stack is a circular stack, So the last node's next node should
		// point the first node.
		last.next = first;
		// increment the numberOFitem.
		this.numberOfitem++;
	}

	public String pop()
	// --------------------------------------------------------
	// Summary: remove last String that we push and stored in the first node in
	// stack and return it.
	// --------------------------------------------------------
	{
		// assigns string in the first node to a to return later.
		String a = first.item;
		// first starts to point next in the first node. By doing that we cut
		// the link between first and second node and second node become the
		// first node.
		first = first.next;
		// this stack is a circular stack. So in this line I assign next in the
		// last to first to link them.
		last.next = first;
		// decrement the numberOfitem.
		this.numberOfitem--;
		// returns the string.
		return a;
	}

	public boolean isEmpty()
	// --------------------------------------------------------
	// Summary: returns true if stack is empty else returns false.
	// --------------------------------------------------------

	{
		return last == null;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	public class ListIterator implements Iterator<String> {
		// store the first node, order number of the node that we want to
		// start(num), and the number the iterator points(count).
		Node current = first;
		int num;
		int count;

		public ListIterator()
		// --------------------------------------------------------
		// Summary: get a number to the user and by using for loop start point
		// node next to the node that's order is the entered node.
		// --------------------------------------------------------

		{
			System.out.println("Enter the number between 1 and " + numberOfitem + ":");
			Scanner g = new Scanner(System.in);
			// gets a number from the user and add 1.
			num = g.nextInt() + 1;
			// assigns to the count because we will need that number later.
			count = num;
			// start to point the node that we need.
			for (int i = 1; i < num; i++) {
				this.current = this.current.next;
			}

		}

		@Override
		public boolean hasNext()

		// --------------------------------------------------------
		// Summary: this is a circular stack. So every node has a next but we
		// want to get this items in the nodes once. So, this method controls
		// this condition and return true if we need to stop. else it returns
		// false.
		// --------------------------------------------------------
		{
			// TODO Auto-generated method stub

			return count < num + numberOfitem;
		}

		@Override
		public String next()
		// --------------------------------------------------------
		// Summary: points the next node in the stack and returns the item.
		// --------------------------------------------------------
		{
			// TODO Auto-generated method stub
			String item = current.item;
			count++;
			current = current.next;
			return item;
		}

	}

}

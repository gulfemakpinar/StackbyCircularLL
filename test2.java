import java.util.*;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creates a circular stack
		StackbByCircularLL s = new StackbByCircularLL();
		// push 20 items in to stack and prints it .
		for (int i = 1; i <= 20; i++) {

			System.out.println("push item: " + i);
			s.push("" + i);

			System.out.println();
		}

		// prints all strings in the stack.
		System.out.println("Strings in queue:");
		for (String a : s) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int i = 1; i <= 5; i++) {

			// pop a String from the queue and print it

			String x = s.pop();
			System.out.println("push item: " + x);

			System.out.println();
		}
		// prints all strings in the stack.
		System.out.println("Strings in queue:");
		for (String a : s) {
			System.out.print(a + " ");
		}

	}

}

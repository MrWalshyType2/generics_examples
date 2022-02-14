package generics.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Runner {

	public static void main(String[] args) {
		// NON GENERIC:
//		LinkedList myNumbers = new LinkedList();
//		myNumbers.append(32);
//		
//		System.out.println(myNumbers); // [32]
//		Object number = myNumbers.get(0);
//		Integer typecasted = (Integer) number;
//		System.out.println(typecasted); // 32
//		
//		myNumbers.append("hello");
//		System.out.println(myNumbers);
		
		// we cannot convert a string to an integer
//		Integer other = (Integer) myNumbers.get(1);
//		System.out.println(other);
		
//		======================================================================
//		GENERIC:
//		GenericSequence<Integer> myNumbers = new GenericLinkedList<>();
//		
//		myNumbers.append(10);
//		System.out.println(myNumbers); // [10]
//		System.out.println("SEQUENCE CONTAINS 10: " + myNumbers.contains(10));
//		Integer number = myNumbers.get(0);
//		System.out.println(number); // 10
//		
//		myNumbers.append(20);
//		myNumbers.append(30);
//		System.out.println(myNumbers);
//		System.out.println("SEQUENCE CONTAINS 20: " + myNumbers.contains(20));
//		System.out.println("SEQUENCE CONTAINS 30: " + myNumbers.contains(30));
//		
//		myNumbers.insert(0, 0);
//		System.out.println(myNumbers);
//		System.out.println("SEQUENCE CONTAINS 0: " + myNumbers.contains(0));
//
//		
//		myNumbers.insert(myNumbers.length(), 40);
//		System.out.println(myNumbers);
//		System.out.println("SEQUENCE CONTAINS 10: " + myNumbers.contains(40));
//
//		myNumbers.remove(0);		
//		System.out.println(myNumbers);
//		System.out.println("SEQUENCE CONTAINS 0: " + myNumbers.contains(0));
//
//		myNumbers.remove(myNumbers.length() - 1); // removes 40		
//		System.out.println(myNumbers);
//		System.out.println("SEQUENCE CONTAINS 40: " + myNumbers.contains(40));
//
//		System.out.println("SEQUENCE LENGTH IS 3: " + (myNumbers.length() == 3));
		GenericLinkedList<String> myList = new GenericLinkedList<String>();
		fill(myList, new String[] {"hello", "fred"});
		System.out.println(myList);
		
		// return true if number is even
		// This is the same as creating a 'class EvenTester implements Predicate<Integer>'
		Predicate<Integer> evenTest = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
			
		};
		GenericSequence<Integer> mySequence = new GenericLinkedList<>();
		mySequence.append(10);
		mySequence.append(11);
		mySequence.append(12);
		mySequence.append(13);
		mySequence.append(14);

		GenericSequence<Integer> onlyEvens = filter(mySequence, evenTest);
		System.out.println(onlyEvens);
	}

	// prepare our sequence
	public static <T> void fill(GenericLinkedList<T> list, T[] items) {
		for (T item : items) {
			list.append(item);
		}
	}
	
	public static <T> GenericSequence<T> filter(GenericSequence<T> list, Predicate<T> predicate) {
		// a Predicate is something that is true or false
		// - it is a interface with a single method that we can use to test something to be true or false
		var output = new GenericLinkedList<T>();
		
		for (int i = 0; i < list.length(); i++) {
			boolean isEven = predicate.test(list.get(i));
			if (isEven) {
				output.append(list.get(i));
			}
		}
		return output;
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		// a Predicate is something that is true or false
		// - it is a interface with a single method that we can use to test something to be true or false
		var output = new ArrayList<T>();
		
		for (int i = 0; i < list.size(); i++) {
			boolean isEven = predicate.test(list.get(i));
			if (isEven) {
				output.add(list.get(i));
			}
		}
		return output;
	}
}

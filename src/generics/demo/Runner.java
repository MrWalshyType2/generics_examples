package generics.demo;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("unique from each other");
		// we can also refer to these objects as unique 'instances' of the String
		// class
		
		
		// Generic: Type parameter
		//		  : Allows us to create type-safe data structures that can be apply them across many different types
		//		  : i.e., we are creating a type (class) that can work with multiple other types (classes)
	
		String myString = "hello";
		Exhibit helloExhibit = new Exhibit(myString);
		helloExhibit.display();
		
		Object obj = helloExhibit.getObject();
		String original = ((String) obj);
		// String original = (String) helloExhibit.getObject();
//		System.out.println(original);
		
		GenericExhibit<String> myNewHelloExhibit = new GenericExhibit<String>(myString);
		myNewHelloExhibit.display();
		String originalCopy = myNewHelloExhibit.getObject();
		
		
		GenericExhibit<Integer> numberExhibit = new GenericExhibit<Integer>(1);
		numberExhibit.display();
		int num = numberExhibit.getObject();
		
		// At compile time, a thing called 'type erasure' occurs
		// - The java compiler will replace all generic types with 'Object'
		// - It will then add type casts where appropriate
		
		// There is only one class file for GenericExhibit, no matter how many
		// different types we use it with
	}

}

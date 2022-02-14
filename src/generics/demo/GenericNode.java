package generics.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class GenericNode<T> {
	
	private T data;
	private GenericNode<T> next;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public GenericNode<T> getNext() {
		return next;
	}
	
	public void setNext(GenericNode<T> next) {
		this.next = next;
	}

	public static void main(String[] args) {
		// var is used for local type reference
		// - the variable on the left will infer the data type from the value on the right
		// - we must initialise variables declared with var on the same line
		GenericNode<String> stringNode1 = new GenericNode<String>();
		var stringNode2 = new GenericNode<String>();
		stringNode1.setData("hello");
		stringNode2.setData("world");
		
		// set next node
		stringNode1.setNext(stringNode2);
		
		GenericNode<String> current = stringNode1;
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}

}

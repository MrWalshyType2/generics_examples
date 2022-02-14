package generics.linkedlist;

public class LinkedList implements Sequence {
	
	private int size;
	private Node head;
	
	public LinkedList() {
		size = 0;
	}

	@Override
	public float capacity() {
		return Float.POSITIVE_INFINITY;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public boolean contains(Object element) {
		Node current = this.head;
		
		if (current != null && current.getNext() != null) { // list has more than 1 element
			while (current.getNext() != null) {
				if (current.getItem() != null && current.getItem().equals(element)) {
					return true;
				}
				current = current.getNext();
			}
		} else if (current != null) { // list has 1 element
			if (current.getItem() != null && current.getItem().equals(element)) {
				return true;
			}
		}
		return false; // list is empty
		
	}

	@Override
	public Object get(int index) {
		Node current = this.head;
		
		for (int counter = 0; counter < index; counter++) {
			current = current.getNext();
		}
		
		return current.getItem();
	}

	@Override
	public void set(int index, Object element) {
		Node current = this.head;
		
		for (int counter = 0; counter < index; counter++) {
			current = current.getNext();
		}
		
		current.setItem(element);
	}

	@Override
	public void append(Object element) {
		this.insert(size, element);
	}

	@Override
	public void remove(int index) {
		if (this.size > 0) {
			if (index == 0) {
				this.head = this.head.getNext();
			} else {
				Node before = this.head;
				
				for (int i = 0; i < index - 1; i++) {
					before = before.getNext();
				}
				before.setNext(before.getNext().getNext()); // set the node before the index to the one after the index to be removed
			}
			this.size--;
		}
	}
	
	@Override
	public void insert(int index, Object element) {
		Node newNode = this.new Node();
		newNode.setItem(element);
		
		if (index == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			Node before = this.head;
			
			for (int i = 0; i < index - 1; i++) {
				before = before.getNext();
			}
			newNode.setNext(before.getNext());
			before.setNext(newNode);
		}
		this.size++;
	}
	
	@Override
	public String toString() {
		Node current = this.head;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		while (current != null) {
			sb.append(current.getItem());
			current = current.getNext();
			
			if (current != null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	// private because a node does not exist outside of the linked list
	// - it is an implementation detail
	private class Node {
		
		private Object item;
		private Node next;
		
		public Node() {
			
		}

		public Object getItem() {
			return item;
		}

		public void setItem(Object item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}

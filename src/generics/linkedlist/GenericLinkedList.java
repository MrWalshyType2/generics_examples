package generics.linkedlist;

public class GenericLinkedList<T> implements GenericSequence<T> {

	private int size;
	private Node<T> head;
	
	public GenericLinkedList() {
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
	public boolean contains(T element) {
		Node<T> current = this.head;
		
		if (current != null && current.getNext() != null) { // list has more than 1 element
			while (current != null) {
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
	public T get(int index) {
		Node<T> current = this.head;
		
		for (int counter = 0; counter < index; counter++) {
			current = current.getNext();
		}
		
		return current.getItem();
	}

	@Override
	public void set(int index, T element) {
		Node<T> current = this.head;
		
		for (int counter = 0; counter < index; counter++) {
			current = current.getNext();
		}
		
		current.setItem(element);
	}

	@Override
	public void append(T element) {
		this.insert(size, element);
	}

	@Override
	public void remove(int index) {
		if (this.size > 0) {
			if (index == 0) {
				this.head = this.head.getNext();
			} else {
				Node<T> before = this.head;
				
				for (int i = 0; i < index - 1; i++) {
					before = before.getNext();
				}
				before.setNext(before.getNext().getNext()); // set the node before the index to the one after the index to be removed
			}
			this.size--;
		}
	}
	
	@Override
	public void insert(int index, T element) {
		Node<T> newNode = this.new Node<T>();
		newNode.setItem(element);
		
		if (index == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			Node<T> before = this.head;
			
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
		Node<T> current = this.head;
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

	private class Node<T> {
		
		private T item;
		private Node<T> next;
		
		public Node() {
			
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
		
	}
}

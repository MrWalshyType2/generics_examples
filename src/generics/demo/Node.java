package generics.demo;

public class Node {

	private int data;
	private Node next;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public static void main(String[] args) {
		Node n1 = new Node();
		n1.setData(5);
		Node n2 = new Node();
		n2.setData(7);
		Node n3 = new Node();
		n3.setData(53);
		
		// set n2 as the node after n1, i.e., n1.next is equal to n2
		n1.setNext(n2);
		n2.setNext(n3);
		
		Node current = n1;
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}

}

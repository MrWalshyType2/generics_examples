package generics.demo;

public class Exhibit {
	
	private Object object;
	
	public Exhibit(Object object) {
		this.object = object;
	}
	
	public void display() {
		System.out.println(object.toString());
	}
	
	public Object getObject() {
		return object;
	}
}

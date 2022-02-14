package generics.demo;

/* Common generic conventions:
 * 
 * - E for Element
 * - K for a map key
 * - V for a map value
 * - N for a number
 * - T for a generic data type
 * - S,U,V,... for multiple generic types
 * 
 */

// Formal type parameters are specified with the diamond operator
// - generics are a type of polymorphism (parametric/generic polymorphism)
// - it exists alongside subtype polymorphism (inheritance)
public class GenericExhibit<T> {
	// T represents a data type we can use anywhere inside 
	// this class (where you would use a reference type)
	// - Generics do not work with primitives
	private T object;
	
	public GenericExhibit(T object) {
		this.object = object;
	}
	
	public void display() {
		System.out.println(object.toString());
	}
	
	public T getObject() {
		return object;
	}
}

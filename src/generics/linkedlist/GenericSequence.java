package generics.linkedlist;

/**
 * A sequence ADT that uses generic types.
 * @author Morgan Walsh
 *
 * @param <T>
 */
public interface GenericSequence<T> {

	/**
	 * The number of items the sequence can hold.
	 * @return
	 */
	public float capacity();
	
	/**
	 * The actual number of items in the sequence.
	 * @return
	 */
	public int length();
	
	/**
	 * Returns true if the sequence contains the specified element.
	 * @param element
	 * @return
	 */
	public boolean contains(T element);
	
	/**
	 * Returns the item at the specified index.
	 * @param index, an integer index
	 * @return
	 */
	public T get(int index);
	
	/**
	 * Sets the element at the specified index.
	 * @param index
	 * @param element
	 */
	public void set(int index, T element);
	
	/**
	 * Inserts the element at the specified index.
	 * @param index
	 * @param element
	 */
	public void insert(int index, T element);
	
	/**
	 * Appends an element to the end of the sequence.
	 * @param element
	 */
	public void append(T element);
	
	/**
	 * Removes the element from the sequence at the specified index.
	 * @param index
	 */
	public void remove(int index);
	
}

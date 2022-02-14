package generics.linkedlist;

/**
 * Represents the Sequence ADT (abstract data type)
 * @author Morgan Walsh
 *
 */
public interface Sequence {

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
	public boolean contains(Object element);
	
	/**
	 * Returns the item at the specified index.
	 * @param index, an integer index
	 * @return
	 */
	public Object get(int index);
	
	/**
	 * Sets the element at the specified index.
	 * @param index
	 * @param element
	 */
	public void set(int index, Object element);
	
	/**
	 * Inserts the element at the specified index.
	 * @param index
	 * @param element
	 */
	public void insert(int index, Object element);
	
	/**
	 * Appends an element to the end of the sequence.
	 * @param element
	 */
	public void append(Object element);
	
	/**
	 * Removes the element from the sequence at the specified index.
	 * @param index
	 */
	public void remove(int index);
}

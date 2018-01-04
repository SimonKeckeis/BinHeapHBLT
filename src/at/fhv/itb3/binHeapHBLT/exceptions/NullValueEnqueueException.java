package at.fhv.itb3.binHeapHBLT.exceptions;

/**
 * Exception thrown if a new node with a null value should be added to the heap.
 * @author ske2577
 * <p>Created on: 22.11.17</p>
 * @version 1
 *
 */
public class NullValueEnqueueException extends HBLTException{

	public NullValueEnqueueException(String message) {
		super(message);
	}

}

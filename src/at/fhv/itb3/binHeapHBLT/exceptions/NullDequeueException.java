package at.fhv.itb3.binHeapHBLT.exceptions;

/**
 * Exception thrown if the heap is empty but the dequeue method is called
 * @author ske2577
 * <p>Created on: 22.11.17</p>
 * @version 1
 *
 */
public class NullDequeueException extends HBLTException{

	public NullDequeueException(String message) {
		super(message);
	}

}

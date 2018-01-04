package at.fhv.itb3.binHeapHBLT.exceptions;

/**
 * General Exception for the BinHeapHBLT
 * @author ske2577
 * <p>Created on: 22.11.17</p>
 * @version 1
 *
 */
public abstract class HBLTException extends Exception{
	public HBLTException(String message){
		System.err.println(message);
	}
}

package at.fhv.itb3.binHeapHBLT;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import at.fhv.itb3.binHeapHBLT.exceptions.*;

/**
 * A basic class to represent a Height-Bias_leftist-Tree. The value with the highest priority is always the root node. Both inserting and removing 
 * make use of the merge method which merges 2 separate HBLTs into one.
 * @author ske2577
 * <p>Created on: 22.11.17</p>
 * @version 1
 *
 */
public class BinHeapHBLT<T> {
	
	/**
	 * Class to represent a HBLT node. Each node has a numeric rank (=s-value) starting from 1;
	 * @author ske2577
	 * <p>Created on: 22.11.17</p>
	 * @version 1
	 *
	 */
	private class Node{
		private T _value;
		private int _s = 1;

		private Node _left;
		private Node _right;

		public Node(T value) {
			_value = value;
		}

	}
	
	private Node _root;
	private Comparator<T> _comparator;


	/**
	 * Method to initialize the heap with a Comparator to compare priorities
	 * @param c is a valid Comparator
	 */
	public void create(Comparator<T> c) {
		_comparator = c;
	}
	
	/**
	 * Checks if the tree is empty
	 * @return True, if the tree is empty. False, if the tree is not empty.
	 */
	public boolean isEmpty() {
		return _root == null;
	}
	
	/**
	 * Inserts a new value into the tree. Makes use of the merge method.
	 * @param value is the new value to add
	 * @throws NullValueEnqueueException
	 */
	public void enqueue(T value) throws NullValueEnqueueException{
		if (value != null) {
			Node newNode = new Node(value);
			_root = merge(_root, newNode);
		} else {
			throw new NullValueEnqueueException("Value must not be null");
		}
	}
	
	/**
	 * Removes the root node (= node with highest priority) and merges the two separated trees back into one
	 * @return The value of the root node
	 * @throws NullDequeueException
	 */
	public T dequeue() throws NullDequeueException{
		if (!isEmpty()) {
			T out = _root._value;
			_root = merge(_root._left, _root._right);

			return out;
		}

		throw new NullDequeueException("Cannot dequeue value from empty tree");
	}
	
	/**
	 * Merges two nodes. Used in the enqueue and dequeue method. Inserts new nodes into the tree and checks if the HBLT conditions apply. If not, then the nodes 
	 * will be swapped until the conditions apply.
	 * @param n1 is the first node
	 * @param n2 is the second node
	 * @return The root node
	 */
	private Node merge(Node n1, Node n2){
		//abort condition e.g. if root empty or path end reached
		if (n1 == null) {
			return n2;
		}
		    
		//used when the root value has no right child
		if (n2 == null) {
			return n1;
		}

		//swap node if n1 < n2
		if(_comparator.compare(n1._value, n2._value) < 0){
			Node temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		n1._right = merge(n1._right, n2);
		
		//swap values to meet hblt conditions
		if (n1._left == null) {
			n1._left = n1._right;
			n1._right = null;
		} else {
			//check s-value condition of the hblt tree
			if (n1._left._s < n1._right._s) {
				Node temp = n1._left;
				n1._left = n1._right;
				n1._right = temp;
			}
			
			//Increment from new right child, because old right child has already been updated from recursion ascend 
			n1._s = n1._right._s + 1;
		}
		
		return n1;
	}
	

	/**
	 * Method used to test
	 */
	public void printTree(){
		LinkedList<Node> q = new LinkedList<>();
		q.add(_root);
		while (!q.isEmpty()) {
			Node el = q.removeFirst();
			if (el != null) {
				System.out.println(el._value + "--> s = " + el._s);
				q.add(el._left);
				q.add(el._right);
			}
		}
	}
	
	/**
	 * Method used to test
	 * @return a list of all tree values
	 */
	public List<T> getTreeValuesLevelByLevel(){
		LinkedList<T> out = new LinkedList<>();
		LinkedList<Node> q = new LinkedList<>();

		q.add(_root);
		while (!q.isEmpty()) {
			Node el = q.removeFirst();

			if (el != null) {
				out.add(el._value);
				q.add(el._left);
				q.add(el._right);
			}
		}

		return out;
	}
	
	/**
	 * Method used to test
	 * @return a list of all tree colours
	 */
	public List<Integer> getTreeSValueLevelByLevel(){
		LinkedList<Integer> out = new LinkedList<>();
		LinkedList<Node> q = new LinkedList<>();

		q.add(_root);
		while (!q.isEmpty()) {
			Node el = q.removeFirst();

			if (el != null) {
				out.add(el._s);
				q.add(el._left);
				q.add(el._right);
			}
		}

		return out;
	}
	
}

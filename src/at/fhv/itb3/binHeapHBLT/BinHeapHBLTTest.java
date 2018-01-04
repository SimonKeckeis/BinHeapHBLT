package at.fhv.itb3.binHeapHBLT;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import at.fhv.itb3.binHeapHBLT.exceptions.*;
import org.junit.Test;


public class BinHeapHBLTTest {

	@Test
	public void testIsEmpty() throws HBLTException {
		BinHeapHBLT<Integer> b = new BinHeapHBLT<>();
		b.create(new MyIntegerComparator());
		
		BinHeapHBLT<Integer> b1 = new BinHeapHBLT<>();
		b1.create(new MyIntegerComparator());
		
		b.enqueue(3);
		b.enqueue(4);
		b.enqueue(1);
		
		assertFalse(b.isEmpty());
		assertTrue(b1.isEmpty());
		
	}

	@Test
	public void testEnqueue() throws HBLTException {
		BinHeapHBLT<Integer> b = new BinHeapHBLT<>();
		b.create(new MyIntegerComparator());
		
		b.enqueue(3);
		b.enqueue(4);
		b.enqueue(1);
		b.enqueue(0);
		b.enqueue(-1);
		
		List<Integer> l = Arrays.asList(4,1,3,0,-1);
		List<Integer> lTree = b.getTreeValuesLevelByLevel();
		boolean equals = true;
		for (int i = 0; i < l.size(); i++) {
			if(!l.get(i).equals(lTree.get(i))){
				equals = false;
			}
		}
		
		List<Integer> sList = Arrays.asList(2,2,1,1,1);
		List<Integer> sTree = b.getTreeSValueLevelByLevel();
		boolean sEquals = true;
		for (int i = 0; i < sList.size(); i++) {
			if(!sList.get(i).equals(sTree.get(i))){
				sEquals = false;
			}
		}
		
		assertTrue(equals);
		assertTrue(sEquals);
		
		
		//test null enqueue exception
		BinHeapHBLT<Integer> b1 = new BinHeapHBLT<>();
		b1.create(new MyIntegerComparator());
		
		try{
			b1.enqueue(null);
			fail("Exception not thrown");
		}catch(NullValueEnqueueException e){
			//exception thrown
		}
		
		assertTrue(b1.isEmpty());
	}

	@Test
	public void testDequeue() throws HBLTException {
		BinHeapHBLT<Integer> b = new BinHeapHBLT<>();
		b.create(new MyIntegerComparator());
		
		b.enqueue(3);
		b.enqueue(4);
		b.enqueue(1);
		
		int n = b.dequeue();
		
		assert(n == 4);
		
		//test null dequeue exception
		BinHeapHBLT<Integer> b1 = new BinHeapHBLT<>();
		b1.create(new MyIntegerComparator());
		n = 0;
		try{
			n = b1.dequeue();
			fail("Exception not thrown");
		}catch(NullDequeueException e){
			//exception thrown
		}
		
		assert(n == 0);
	}

}

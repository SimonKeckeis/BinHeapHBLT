package at.fhv.itb3.binHeapHBLT;

import java.util.Comparator;

public class MyIntegerComparator implements Comparator<Integer> {

	public int compare(Integer a, Integer b)
    {
        if(a.compareTo(b)>0)
        return 1;
        else if(a.compareTo(b)<0)
            return -1; 
        else 
            return 0;
    }



}

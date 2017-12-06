package com.stone.thread.T11;

public class StateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int COUNT_BITS = Integer.SIZE - 3;
		int CAPACITY   = (1 << COUNT_BITS) - 1;
		int RUNNING    = -1 << COUNT_BITS;
		int SHUTDOWN   =  0 << COUNT_BITS;
	    int STOP       =  1 << COUNT_BITS;
	    int TIDYING    =  2 << COUNT_BITS;
	    int TERMINATED =  3 << COUNT_BITS;
	    
	    
		   
		System.out.println(COUNT_BITS); 
		System.out.println(Integer.toBinaryString(CAPACITY));  
		System.out.println(Integer.toBinaryString(RUNNING));   
		System.out.println(Integer.toBinaryString(SHUTDOWN));
		System.out.println(Integer.toBinaryString(STOP));  
		System.out.println(Integer.toBinaryString(TIDYING));
		System.out.println(Integer.toBinaryString(TERMINATED));
		
		
		
		
	}

}

package SkipList;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;


public class TestingFunctions {
	public static void main(String[] args) {
		long[][] avgTime;
		avgTime = new long [15][5];
		int time = 0; //Starting at time=0.
		for (int i = 512; i<= 10000; i = i*2) {
		SkipList skipList = new SkipList();
		Random rnd = new Random(); 
		
		 // Number of elements on which the program is to be tested. 
		int size = i;
		
		// Variable to generate a random input string of integers.
		int random;   
		
		// Initializing SkipList array
		int[] skArr = new int[size]; 
		
		// Generating sequenckaEmpty of random integers and inserting them into the SkipList array.
		for (int j = 0; j < size; j++) {
			random = 1 + rnd.nextInt(10000);
			skArr[j] = random;}
		
		// Insert elements into SkipList array(skArr).
		for (int x : skArr) {
			skipList.elementInsert(x); }
		skipList.printDictionary();
		
		// Testing SkipList functions:
		
		// Element search. 
		long fullSkiplist = System.nanoTime();
		for (int j = 0; j < 40; j++) {
			skipList.elementSearch(skArr[32]);} 
		long emptySkiplist = System.nanoTime();
		long sucfind = ((emptySkiplist - fullSkiplist)/60);
		System.out.println("\n");
		
		
		// Insert and Remove
		long removetime = 0;
		long inserttime = 0;
		int irs = rnd.nextInt(size) + 1;
		for (int j = 0; j < 40; j++) {
			long rs = System.nanoTime();
			skipList.removeElement(skArr[irs]);
			long re = System.nanoTime();
			removetime = removetime + (re - rs);
			
			long fsi = System.nanoTime();
			skipList.elementInsert(skArr[irs]);
			long fei = System.nanoTime();
			System.out.println("Element " + skArr[irs] + " was inserted into SkipList");
			inserttime = inserttime + (fei - fsi);
		}
		
		//Closest Key After
		int cka = rnd.nextInt(size) + 1;
		long cka_time = System.nanoTime();
		for (int j = 0; j < 40; j++) {
			skipList.closestKeyAfter(skArr[cka]);}
		long ckaEmpty = System.nanoTime();
		System.out.println("\n");
		
		//Find Element (unsucckaEmptyssful)
				long fullSkiplist2 = System.nanoTime();
				for (int j = 0; j < 40; j++) {
					if (skipList.elementSearch(600000) == -1) {
						System.out.println("Element not found in SkipList");
					}}
				long emptySkiplist2 = System.nanoTime();
				long unsucfind = ((emptySkiplist2 - fullSkiplist2)/40);
				System.out.println("\n");
		
		avgTime[time][0] = size;
		avgTime[time][1] = ((sucfind + unsucfind)/40);
		avgTime[time][2]= ((ckaEmpty - cka_time)/40);
		avgTime[time][3] = (removetime/40);
		avgTime[time][4] = (inserttime/40);
		
		time++;
		skipList.printDictionary();
		} 
		
		String s1 = "Sample Size"; 
		String s2 = "ElementSearch(ns)";
		String s3 = "closestKeyAfter(ns)"; 
		String s4 = "removeElement(ns)";
		String s5 = "ElementInsert(ns)";
		System.out.println("################################################################################################################################################");
		System.out.printf("%30s|%30s|%30s|%30s|%30s|", s1, s5, s3, s2, s4);
		System.out.printf("\n%30s|%30s|%30s|%30s|%30s|", " ", " ", " ", " ", " ");
		for (int i = 0; i < avgTime.length; i++) {
			System.out.println("\n");
			for (int j = 0; j < 5; j++) {
				System.out.printf("%30s|",avgTime[i][j]);
			}
		}
		System.out.println("\n#############################################################################################################################################");
}

}
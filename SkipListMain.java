package Skiplist;

import java.util.Scanner;

public class SkipListMain {
	public static void main(String[] args) {
		System.out.println("");
		System.out.println("SkipList Data Structure Implementation (Part 1)");
	Scanner input = new Scanner(System.in); char yn;
	SkipList beta = new SkipList();
	do {
		System.out.println("Let Us Test The SkipList Data Structure\n");
		System.out.println("1. Insert Element\n");
		System.out.println("2. Find Element\n");
		System.out.println("3. Closest Key After\n");
		System.out.println("4. Remove Element\n");
		int selection = input.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Please Enter Element to Insert");
			int ins = input.nextInt();
			beta.insertElement(ins);
			System.out.println("Element " + ins + " was Inserted");
			break;
		case 2:
			System.out.println("Please Enter Element to Find");
			int fin = input.nextInt();
			beta.findElement(fin);
			if (beta.findElement(fin) == -1) {
			System.out.println("Element " + fin + " was not found");} 
			break;
		case 3:
			System.out.println("Please Enter Key to Search");
			int key = input.nextInt();
			beta.closestKeyAfter(key);
			if (beta.closestKeyAfter(key) == -1) {
				System.out.println("Element after " + key + " does not exist in SkipList");}
			break;
		case 4:
			System.out.println("Please Enter Elemet to Remove");
			int rem = input.nextInt();
			beta.removeElement(rem);
			break;
		}
		
		beta.printDictionary();
		System.out.println("Want to continue? Type in 'Y' or 'N'\n");
		yn = input.next().charAt(0);
	} while (yn == 'Y' || yn == 'y');
}

}

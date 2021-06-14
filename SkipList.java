package Skiplist;

import java.util.Random;

public class SkipList implements ODADT {
	
	private Random coin; 
	private Nodes nodeOne; 
	static int NumLevels = 20;
	// The variable Coin will decide whether..
	// to add a new level or not depending on the heads or tails value.
	
	
	public SkipList () {
		coin = new Random(); 
		nodeOne = new Nodes(-1);
	}

	//Method to find an element in the Skiplist.
	@Override
	public int elementSearch(int contents) {
	
		for (int i = NumLevels - 1; i >= 0; i--) {
			if ((nodeOne.elementSearch(contents, i)) != null) {
				System.out.println("Element " + contents + " found at Level " + i);
				return i;
			}
			
		} return -1;

	}


	//Method to insert an element in the Skiplist.
	@Override
	public void elementInsert(int contents) {
	
		Nodes insert_node = new Nodes(contents);
		for (int i = 0; i < NumLevels; i++) {
			int coinx = coin.nextInt((int) Math.pow(2, i));
			if (coinx != 0) {
				break;
			}
			nodeOne.elementInsert(node,  i);
		}

	}


	//Method to remove an element in the Skiplist.
	@Override
	public void removeElement(int contents) {
		
		Nodes remove_node = findElement(contents);
		if (remove_node == null) {
			System.out.println("Element " + contents + " not found in the SkipList");return;
		}
		remove_node.contents = -1;
		for (int i = 0; i < NumLevels; i++) {
			nodeOne.linkingNodes(i);
		}
		System.out.println("Element " + contents + " removed from the SkipList");

	}
	
	//Method to find an element in the SkipList.
	public Nodes findElement(int contents) {
		Nodes find_node = null;
		for (int i = NumLevels - 1; i >=0; i--) {
			if ((find_node = nodeOne.elementSearch(contents, i))!= null) {
				break;
			}
		} return find_node; 
	}
	//This variable(find_node) will be null if no such node is found.

	//Method to find an element closest to the given key in the Skiplist.
	@Override
	public int closestKeyAfter(int k) {
		
		Nodes closest_node = null;
		for (int i = NumLevels - 1; i >= 0; i--) {
			if ((closest_node = nodeOne.elementSearch(k, i)) != null) {
				if (closest_node.getNextNode(i) != null) {
					int x =  closest_node.getNextNode(i).contents;
					System.out.println("The Closest Key After " + k + " is " + x);
					return x;
				}
			}
		} 
		return -1;
	}
	

	public void printDictionary() {
		System.out.println("\n" + "Skip List: ");
		for (int i = 0; i < NumLevels; i++) {
			nodeOne.lvlprint(i);
		} System.out.println("");
	}

}

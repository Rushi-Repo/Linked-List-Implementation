package Skiplist;

//Nodes class to be called in SkipList.java
public class Nodes {

	int contents;
	Nodes[] nodes = new Nodes[SkipList.NumLevels];

	// Method to get contents(integer value) from the next node.
	public Nodes getNextNode(int val) {
		return nodes[val];
	}
	
	// Populating contents in a node.
	public Nodes(int contents) {
		this.contents = contents;
	}
	// Populating contents in the next node.
	public void setNextNode(Nodes nxtnode, int val) {
		nodes[val] = nxtnode;
	}
	
	// Implementation of Linking of the presentNode and next nodes.
	public void linkingNodes(int contents) {
		Nodes presentNode = this.getNext(contents);
		while (presentNode != null && presentNode.getNext(contents) != null) {
			if (presentNode.getNext(contents).contents == -1) {
				Nodes nxt = presentNode.getNext(contents);
				Nodes nxt1 = nxt.getNext(contents);
				presentNode.setNext(nxt1, contents);
				return;
			}
			presentNode = presentNode.getNext(contents);
		}
	}

	// Search element in the list.
	public Nodes elementSearch (int contents, int val) {
		Nodes p = null;
		Nodes presentNode = this.getNext(val);
		while (presentNode != null && presentNode.contents <= contents) {
			if (presentNode.contents == contents) {
				p = presentNode; break;
			}
			presentNode = presentNode.getNext(val);
		}
		return p;
	}

	// Insert Element
	public void elementInsert(Nodes nxtnode, int val) {
		Nodes presentNode = getNext(val);
		// Empty list
		if (presentNode == null) {
			this.setNext(nxtnode, val); return;
		}
		// New element less than presentNode element
		if (nxtnode.contents < presentNode.contents) {
			this.setNext(nxtnode, val);nxtnode.setNext(presentNode, val);return;
		}
		// New element greater than presentNode element
		while (presentNode.getNext(val) != null && presentNode.contents < nxtnode.contents && presentNode.getNext(val).contents < nxtnode.contents) {	
			presentNode = presentNode.getNext(val);
		}
		Nodes nxt = presentNode.getNext(val);
		presentNode.setNext(nxtnode, val);nxtnode.setNext(nxt, val);
	}

	// Display the total number of levels produced by the SkipList class.
	public void printLevels (int val) {
		String p = "Level" + val + ": ";
		Nodes presentNode = getNext(val);
		
		while (presentNode != null) {
			p += presentNode.contents + " "; presentNode = presentNode.getNext(val);
		}
		System.out.println(p);
	}
	
}
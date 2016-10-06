package lab4_linkedlists;

public class LinkedList {
	private Box head;
	private Box iterator;
	private int size;

	LinkedList() {
		size = 0;
		head = null;
		//iterator = null;
	}

	/*
	 * is empty?
	 */
	public boolean isEmpty() {
		//or if size = 0;
		if (head == null)
			return true;
		return false;
	}

	/* Add b as the FIRST node of the linked list. 
	 * EXTRA METHOD*/
	void addNodeFront(Box b) {
		// Add the node in front of the linked list
		b.next = head; // b is going to point to the head (start of the list)
		head = b; // the head is going to point the new node
		size++;

	}
	
	/* Add b as the LAST node of the linked list. */
	void addNode(Box b) {
		if (isEmpty())
			addNodeFront(b);
		else {
			Box temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = b;
		}
		size++;
	}

	/* Insert b in position pos. If insertion is successful * return true,
	 * otherwise return false.
	 */
	boolean insertNode(Box b, int pos) {
		if (pos < 0 || pos > getSize()) 
			return false;
		else{
			Box temp = head; //create an empty box 'placeholder'
			while(pos>0){
				temp = temp.next;
				pos--;
			}
			temp.next = b;
			b.next = temp.next;
			size++;
		}
		return true;
	}

	int getSize() {
		return size;
	}

	/**
	 * Print width, height, length, and volume of each of the boxes in this
	 * linked list.
	 */
	void printAllBoxes() {
		Box temp = head;
		int i = 0;
		while (temp != null) {
			System.out.println("BOX" + i + " has the following attributes: ");
			System.out.println("W: " + temp.getW());
			System.out.println("H: " + temp.getH());
			System.out.println("L: " + temp.getL());
			System.out.println(); // Blank Line for good better format
			temp = temp.next; i++;
		}
	}

	// volume of each of the boxes in
	/**
	 * Remove the box in position pos. is successful, otherwise return false.
	 */
	boolean removeNode(int pos) {
		return false;
	}

	/** Return the box in position pos. * invalid. */
	Box getBox(int pos) {
		Box temp = head;
		while(pos>0){
			pos--;
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Print width, height, length, and this linked list in reverse order.
	 */
	void printReverse() {
		//FIX
		LinkedList newList = new LinkedList();
		Box temp = head;
		int i = 0;
		while(temp != null){
			newList.addNode(temp);
			System.out.println("ADDED "+i);
			temp = temp.next;
		}//end while
		
		Box it = newList.head;
		while(it != null){
			it.printBox();
			it = it.next;
		}
	}

	/** Initiate the iterator variable */
	void initiateIterator() {
//		iterate = 
		
//		this.iterator = new Iterator(){
//
//			@Override
//			public boolean hasNext() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public Box next() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		};
	}

	/* Return the box in the current iterator position. */
	Box getNextBox() {
		Box temp = head;
		if(temp.next != null){
			return temp.next;
		};
		return null;
	}

}

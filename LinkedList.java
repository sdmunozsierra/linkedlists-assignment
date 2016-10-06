package lab4_miguel;

public class LinkedList {
	private Box head;
	private Box iterator;
	private int size;

	/* Constructor [DONE] */
	LinkedList() {
		size = 0;
		head = null;
	}

	/* Is empty?  [EXTRA METHOD] */
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
	
	/* Add b as the LAST node of the linked list. [DONE]*/
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
			Box prev = temp;
			while(pos>0){
				temp = temp.next;
				pos--;
			}
			prev.next = b;
			b.next = temp;
			size++;
		}
		return true;
	}

	int getSize() {
		return size;
	}
	

	/**
	 * Print width, height, length, and volume of each of the boxes in this
	 * linked list. [DONE]
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

	/** [DONE]
	 * Remove the box in position pos. is successful, otherwise return false.
	 */
	boolean removeNode(int pos) {
		if (pos < 0 || pos > getSize()) 
			return false;
		else{
			Box temp = head; //create an empty box 'placeholder'
			Box prev = null;
			while(pos>0){
				prev = temp;
				temp = temp.next;
				pos--;
			}
			prev.next = temp.next;
			size--;
		}
		return true;
	}

	/** 
	 * Return the box in position pos. Return null when pos is invalid.
	 */
	Box getBox(int pos) {
		Box temp = head;
		while(pos>0){
			pos--;
			temp = temp.next;
		}
		return temp;
		
		//IF POSITION INVALID RETURN NULL [Missing]
		
	}

	/** 
	 * Print width, height, length, and this linked list in reverse order.
	 */
	void printReverse() {
		LinkedList newL = new LinkedList();
		Box temp = head;
		while (temp != null) {
			newL.addNode(temp);
			temp = temp.next;
		}
		newL.printAllBoxes();
		
	}

	/** Initiate the iterator variable [DONE]*/
	void initiateIterator() {
		this.iterator = head;
	}

	/* Return the box in the current iterator position. [DONE]*/
	Box getNextBox() {
		Box returnable;
		//Return first element
		if(iterator == head){
			//System.out.println("BASE");
			returnable = iterator; //save value
			iterator = iterator.next; //adv to next
			return returnable;
		}
		//Not the first element
		else{
			//Last element
			if(iterator == null){
				return null;
			}
			//Middle element
			//System.out.println("MIDDLE");
			returnable = iterator; //save value
			iterator = iterator.next;
			return returnable;
		}//end else
	}

}

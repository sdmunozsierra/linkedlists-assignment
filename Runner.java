package lab4_miguel;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Runner {

	public static void main(String[] args) {

		/* Step 1: Create a linked list */
		System.out.println("Creating a linked list... ");
		LinkedList linked = new LinkedList(); // Creates an empty linked list

		// Test if the linked list has any elements (should not)
		System.out.println("Is linked list empty? -> " + linked.isEmpty() + "\n");

		/* Step 2: Create a box to test on the linked list */
		System.out.println("Creating a Box... ");
		Box testBox = new Box(1, 1, 1, 1);

		// Test the Box methods (getVolume and isCube)
		System.out.println("Volume of testBox: " + testBox.getVolume()); // get
																			// volume
		System.out.println("Is testBox cube? -> " + testBox.isCube() + "\n"); // isCube

		/* Step 3: Insert the Box in the linked list */
		System.out.println("Adding testBox to linked");
		linked.addNodeFront(testBox);

		// Test if the linked list has any elements (should have an element)
		System.out.println("Is linked list empty? -> " + linked.isEmpty() + "\n");

		/* Step 4: Test methods in linked list class */
		linked.printAllBoxes(); // Print all Boxes

		/* TASK 1: 
		 * create a linked from file (done)
		 * print the original sequence (done)
		 * print backwards*/
		System.out.println("READING A FILE AND CREATING LINKED LIST...");
		LinkedList linkedFile = createLinkedList();
		System.out.println("is read file empty? -> " + linkedFile.isEmpty());

		// Print the contents of the linked list read file
		linkedFile.printAllBoxes();

		/** Task 5: Remove*/
		System.out.println("REMOVE ");
		linkedFile.removeNode(3);
		linkedFile.printAllBoxes();
		
		/* Task 6: insert */
		System.out.println("Insert ");
		Box newBox = new Box(20,20,20);
		linkedFile.insertNode(newBox, 0);
		linkedFile.printAllBoxes();
		
		/*
		System.out.println("WILL USE ITERATOR 2:\n");
		linkedFile.initiateIterator();
		Box temp;
		while( (temp = linkedFile.getNextBox()) != null){
			temp.printBox();
		}
		*/

		/*** TASKS ***/

		System.out.println("Find Largest Box and Print attributes: ");
		findLargest(linkedFile);

		System.out.println("Find Smallest Box and Print attributes: ");
		findSmallest(linkedFile);
	}// end main

	public static LinkedList createLinkedList() {
		// Create a new Linked List
		LinkedList tempLinked = new LinkedList();

		try {
			// Open the file
			FileInputStream fstream = new FileInputStream("file.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// split the line
				String[] dimensions = strLine.split(" ");
				double w = Double.parseDouble(dimensions[0]);
				double h = Double.parseDouble(dimensions[1]);
				double l = Double.parseDouble(dimensions[2]);

				// Create a box
				Box tempBox = new Box(w, h, l); // pass values
				tempLinked.addNode(tempBox); // add to linked list (in Order)

			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		// Return the linked list
		return tempLinked;
	}
	
	//2. Find the Smallest Box
	public static void findSmallest(LinkedList list) {
		
		//Initialize Iterator
		list.initiateIterator();
		
		//Create Variables
		Box smallest = list.getBox(0);	//Largest box initialize
		Box current; 
		int currPos = 0; int largestPos = 0; 
		
		while( (current = list.getNextBox()) != null){
			currPos++;
			if(smallest.getVolume() > current.getVolume()){
				smallest = current;
				largestPos = currPos; 
			}
			else{
			current = list.getNextBox();
			currPos++;
			}
		}
		
		//Print the result
		smallest.printBoxProperties(largestPos);
	}
	
	//3. Find the Largest Box
	public static void findLargest(LinkedList list) {
		
		//Initialize Iterator
		list.initiateIterator();
		
		//Create Variables
		Box largest = list.getBox(0);	//Largest box initialize
		Box current; 
		int currPos = 0; int largestPos = 0; 
		
		while( (current = list.getNextBox()) != null){
			currPos++;
			if(largest.getVolume() < current.getVolume()){
				largest = current;
				largestPos = currPos; 
			}
			else{
			current = list.getNextBox();
			currPos++;
			}
		}
		
		//Print the result
		largest.printBoxProperties(largestPos);
	}

	//4. How many cubic boxes are on the list? [missing]
}

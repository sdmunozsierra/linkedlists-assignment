package lab4_linkedlists;

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
		System.out.println("Volume of testBox: " + testBox.getVolume()); // get volume
		System.out.println("Is testBox cube? -> " + testBox.isCube() + "\n"); // isCube

		
		/* Step 3: Insert the Box in the linked list */
		System.out.println("Adding testBox to linked");
		linked.addNodeFront(testBox);

		// Test if the linked list has any elements (should have an element)
		System.out.println("Is linked list empty? -> " + linked.isEmpty() + "\n");

		/* Step 4: Test methods in linked list class */
		linked.printAllBoxes(); //Print all Boxes
		
		/* Step 5: Create more boxes from file */
		LinkedList linkedFile = createLinkedList();
		System.out.println("is read file empty? -> "+linkedFile.isEmpty() );
		
		//Print the contents of the linked list read file
		linkedFile.printAllBoxes();
		
		
		/* Step 6: Test Methods */
		/** Print in Reverse */
//		System.out.println("\nPrinting in Reverse...");
//		linked.printReverse();
		
		/* Box at position x */
		Box box2 = linkedFile.getBox(2);
		box2.printBox();
	
		/*Find the smallest element in a Linked List*/
		System.out.println("SIZE: "+linkedFile.getSize());
		findSmallest(linkedFile);
		
		System.out.println("SIZE: "+linkedFile.getSize());
	}
	
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
				
				//Create a box
				Box tempBox = new Box(w, h, l); // pass values
				tempLinked.addNode(tempBox); // add to linked list (in Order)
				
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		//Return the linked list
		return tempLinked;
	}
	
	public static void findSmallest(LinkedList list){
		Box smallest = list.getBox(0);
		for(int i=1; i<list.getSize()-1;i++){
			if(smallest.getVolume()>list.getBox(i).getVolume()){
				smallest = list.getBox(i);
			}
		}
		System.out.println("SMALLEST VOL-> "+ smallest.getVolume());
		
	}

}


package lab4_linkedlists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = null;
		File f = new File("file.txt");
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		//LinkedList linkedFile = createLinkedList(scan);
		
		//System.out.println("is read file empty? -> "+linkedFile.isEmpty() );
		
		Box testBox2 = new Box(2, 2, 2);
		Box testBox3 = new Box(3, 3, 3);
		linked.addNode(testBox2);
		linked.addNode(testBox3);
		System.out.println("ADDED MORE BOXES");
		
		
		
		linked.printAllBoxes();
	
		Box box2 = linked.getBox(0);
		box2.printBox();
		
		//Find the smallest element in a Linked List
		findSmallest(linked);
		
	}
	
	public static LinkedList createLinkedList(Scanner sc){
		//Create a new Linked List
		LinkedList tempLinked = new LinkedList();
		
		//Read line per line (Each box per line)
		while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] dimensions = line.split(" ");
            double w = Double.parseDouble(dimensions[0]);
            double h = Double.parseDouble(dimensions[1]);
            double l = Double.parseDouble(dimensions[2]);
            
            //Create a new Box
            Box tempBox = new Box(w,h,l); //pass values
            tempLinked.addNodeFront(tempBox); //add to linked list
           
            //While Repeat//
        }
		return tempLinked;
	}
	
	public static void findSmallest(LinkedList list){
		Box smallest = list.getBox(0);
		for(int i=1; i<list.getSize();i++){
			if(smallest.getVolume()>list.getBox(i).getVolume()){
				smallest = list.getBox(i);
			}
		}
		System.out.println("INFORMATION-> "+ smallest.getVolume());
		
	}

}

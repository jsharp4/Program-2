/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             JobList.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick, Michael Yang
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
// Author4: Michael Yang, yang363@wisc.edu, yang363, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;
/**
 * This class implements ListADT<Job>, and defines the methods listed within 
 *the ADT. 
 *
 * <p>Bugs: None that we are aware of
 *
 * @author Jon Sharp, Allison Quick, Lindsey Bohr, Michael Yang
 */
public class JobList implements ListADT<Job> {
	//head reference for the listnode
	private Listnode<Job> head;
	//number of items within the Listnode
	private int numItems;
	/*This constructor sets the head reference to null and numItems
	*to 0.
	*/
	public JobList() {
		head = new Listnode<Job>(null);
		numItems = 0;
	}//closes JobList conostructor
	/*This method establishes a new iterator of jobs with a head
	*reference and numItems.
	*@return new JobListIterator(head, numItems)
	*	an iterator that starts at the head reference to numItems
	*/
	public Iterator<Job> iterator() {
		return new JobListIterator(head, numItems);
	}//closes iterator()
	/*This method adds Job item to the end of list.
	*@param Job item
	*	an item that is to be added at the end of the listnode
	*/
	public void add(Job item) {
		//sets a curr reference to head
		Listnode<Job> curr = head;
		//traverses through list to find the end
		while (curr.getNext() != null) {
			curr = curr.getNext();
		} //closes while loop
		//sets the next node to the new item (adds item to end of listnode)
		curr.setNext(new Listnode<Job>(item));
		//updates numItems
		numItems++;
	} //closes add(item)
	/*This method adds Job item to a chosen position
	*@param int pos
	* 	position that the item will be added to Listnode
	*@param Job item
	*	an item that is to be added to Listnode
	*/
	public void add(int pos, Job item) {
		Listnode<Job> curr = head;
		Listnode<Job> newJob = new Listnode<Job>(item);
		//traverses through list until position is reached
		for(int i = 0; i < pos - 1; ++i) {
			curr = curr.getNext();
		}//ends for loop
		//sets the new job into list
		newJob.setNext(curr.getNext());
		curr.setNext(newJob);
		//updates numItems
		numItems++;
	}//closes add(pos, items)
	/*This method returns true iff the item is already in the Listnode
	*@param Job item
	*	an item that is being compared to items in Listnode
	*@return true
	*	iff the item is already in the listnode
	*/
	public boolean contains(Job item) {
		Listnode<Job> curr = head;
		//traverses through list to find a match
		for (int i = 0; i < numItems; ++i) {
			if (curr.getNext().getData().equals(item)) {
				return true;
			}//closes if statement
			curr = curr.getNext();
		}//closes for loop
		return false;
	}//closes contains(item)
	/*This accessor method returns a Job item at a given position
	*@param int pos
	*	position index value used to retrieve information
	*@return curr.getData()
	*	data in Listnode at a certain position
	*/
	public Job get(int pos) {
		Listnode<Job> curr = head;
		//traverses through the Listnode to the pos
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}//closes for loop
		return curr.getData();
	} //closes get(pos)
	/*This method checks to see if the listNode is null
	*@return true
	*	iff the Listnode is empty
	*/
	public boolean isEmpty() {
		if (head.getNext() != null) {
		return false;
		}//closes if statement
		return true;
	}//closes isEmpty()
	/*This method removes a Job item from a position in the Listnode
	*@param int pos
	*	index position in 
	*@return oldJob
	*	the data that is beng removed
	*/
	public Job remove(int pos) {
		Listnode<Job> curr = head;
		//traverses to the desired position
		for(int i = 0; i < pos; ++i) {
			curr = curr.getNext();
		} //closes for loop
		//removes the node from Listnode
		Job oldJob = curr.getNext().getData();
		curr.setNext(curr.getNext().getNext());
		//updates numItems
		numItems--;
		return oldJob;
	}//closes remove(pos)
	/*This method simply returns numItems.
	*@return numItems
	*	number of items in Listnode
	*/
	public int size() {
		return numItems;
	}//closes size()

}//closes JobList

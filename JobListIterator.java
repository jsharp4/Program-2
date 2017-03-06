/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             JobListIterator.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick, Michael Yang
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
// Author4: Michael Yang, yang363@wisc.edu, yang363, LEC 001
// Author5: Kendra Raczek, raczek@wisc.edu, raczek, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements Iterator<Job> and establishes the 
 * methods hasNext() and next().  
 * <p>Bugs: None that we are aware of
 *
 * @author Jon Sharp, Michael Yang, Lindsey Bohr, Allison Quick, Kendra Raczek
 */
public class JobListIterator implements Iterator<Job> {
	private Listnode<Job> items;
	//count for the number of items in the list
	private int numItems;
	//pointer for the position within the list
	private int position;
	
	/* This constructor assigns the parameters items and numItems to
	 * their corresponding variables and marks position as 0.
	 *
	 * @param Listnode<Job> items
	 *	Job items stored a Listnode
	 * @param int numItems
	 *	number of items in a Listnode
	 * @throws IllegalArgumentException()
	 *	If there are no values under items, the exception is thrown
	 */
	public JobListIterator(Listnode<Job> items, int numItems) {
		try {
			if (items == null) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("Cannot create an iterator" 
					 + " with a null list.");
		}
		this.items = items;
		this.numItems = numItems;
		position = 0;
	} //closes constructor
	
	/* This method checks to see if there are more items in the listNode
	 * @return true
	 *	iff the position is less than numItems
	 */
	public boolean hasNext() {
		return position < numItems;
	} //closes hasNext()
	
	/* This method returns the data at a particular location and
	 * increments the position. 
	 * @throws NoSuchElementException()
	 *	If there is not a next value, the exception is thrown
	 * @return items.getData()
	 *	returns the data at a particular position
	 */
	public Job next() {
		try {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
		} catch (NoSuchElementException e) {
			System.out.print("Next element" 
					 + " not found in job list");
		}
		items = items.getNext();
		position++;
		return items.getData();
	} //closes next()

	/* This method removes the Job at the current position in the list.
	 * @throws UnsupportedOperationException()
	 *	This method is not supported by JobListIterator, and will
	 *	throw exception if method is called
	 */
	public void remove() {
		try {
			throw new UnsupportedOperationException();
		} catch (UnsupportedOperationException e){
			System.out.print("JobListIterator does not support"
					 + " the remove() method.");
		}
	} //closes remove()

} //closes JobListIterator class

/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             JobListIterator.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JobListIterator implements Iterator<Job> {
	private Listnode<Job> items;
	private int numItems;
	private int position;
	
	public JobListIterator(Listnode<Job> items, int numItems) {
		this.items = items;
		this.numItems = numItems;
		position = 0;
	}
	
	public boolean hasNext() {
		return position < numItems;
	}

	public Job next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		items = items.getNext();
		position++;
		return items.getData();
	}

}

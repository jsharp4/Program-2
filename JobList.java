/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             JobList.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;

public class JobList implements ListADT<Job> {
	private Listnode<Job> head;
	private int numItems;
	
	public JobList() {
		head = new Listnode<Job>(null);
		numItems = 0;
	}

	public Iterator<Job> iterator() {
		return new JobListIterator(head, numItems);
	}

	public void add(Job item) {
		Listnode<Job> curr = head;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(new Listnode<Job>(item));
		numItems++;
	}

	public void add(int pos, Job item) {
		Listnode<Job> curr = head;
		Listnode<Job> newJob = new Listnode<Job>(item);
		
		for(int i = 0; i < pos - 1; ++i) {
			curr = curr.getNext();
		}
		newJob.setNext(curr.getNext());
		curr.setNext(newJob);
		numItems++;
		
	}

	public boolean contains(Job item) {
		Listnode<Job> curr = head;
		for (int i = 0; i < numItems; ++i) {
			if (curr.getNext().getData().equals(item)) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	public Job get(int pos) {
		Listnode<Job> curr = head;
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		return curr.getData();
	}

	public boolean isEmpty() {
		if (head.getNext() != null) {
		return false;
		}
		return true;
	}

	public Job remove(int pos) {
		Listnode<Job> curr = head;
		
		for(int i = 0; i < pos; ++i) {
			curr = curr.getNext();
		}
		Job oldJob = curr.getNext().getData();
		curr.setNext(curr.getNext().getNext());
		
		numItems--;
		return oldJob;
	}

	public int size() {
		return numItems;
	}

}

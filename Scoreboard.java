/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             Scoreboard.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;
import java.util.LinkedList;

public class Scoreboard implements ScoreboardADT {
	private JobList scores;
	
	public Scoreboard() {
		scores = new JobList();
	}
	
	public int getTotalScore() {
		int total = 0;
		Iterator<Job> itr = scores.iterator();
		while (itr.hasNext()) {
			total += itr.next().getPoints();
		}
		return total;
	}

	public void updateScoreBoard(Job job) {
		scores.add(job);
	}

	public void displayScoreBoard() {
		System.out.println("The jobs completed:");
		Iterator<Job> itr = scores.iterator();
		int position = 0;
		
		while (itr.hasNext()) {
			Job currJob = itr.next();
			System.out.println("Job Name: " + currJob.getJobName() + "\n" +
					"Points earned for this job: " + currJob.getPoints() + "\n" +
					"--------------------------------------------");
		}
		
		}

}

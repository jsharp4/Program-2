/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             Scoreboard.java
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
import java.util.LinkedList;
/**
 * This class implements ScorebordADT and contains methods: getTotalScore(),
 * updateScoreBoard(Job job), displayScoreBoard().  It imports Iterator and
 *LinkedList.  This class stores a job into the JobList and prints out the 
 *Scoreboard's contents.  It iterates to get a total score.
 *
 * <p>Bugs: None that we are aware of
 *
 * @author Jon Sharp, Allison Quick, Lindsey Bohr, Michael Yang
 */
public class Scoreboard implements ScoreboardADT {
	//Linked list of jobs
	private JobList scores;
	//Constructor that assigns a new JobList to scores
	public Scoreboard() {
		scores = new JobList();
	} //closes constructor
	/**
	 * This class iterates through scores and adds the points to 
	 * int total.  It calls iterator(), hasNext() withing the Iterator
	 * and getPoints().
	 * 
	 * @return total
	 *	total number of points in scores
 	 */
	public int getTotalScore() {
		//total number of points in the JobList
		int total = 0; 
		//allows scores to be iterated through
		Iterator<Job> itr = scores.iterator();
		/*while there is still content, iterate through and concatenate
		* the total points.
		*/
		while (itr.hasNext()) {
			total += itr.next().getPoints();
		} //ends while
		return total;
	} //closes getTotalScore()
	/**
	 * This class updates ScoreBoard by adding the job to scores.
	 * 
	 * @param job
	 *	object to be added to the JobList scores
 	 */
	public void updateScoreBoard(Job job) {
		try {
			if (job == null) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("Cannot update a null job.");
		scores.add(job);
	} //closes updateScoreBoard
	/**
	 * This class prints out a message containing the ScoreBoard's
	 * contents.
	 *	
 	 */
	public void displayScoreBoard() {
		System.out.println("The jobs completed:");
		//allows the scores to be iterated through
		Iterator<Job> itr = scores.iterator();
		//iterate through list and print out the job name and points.
		while (itr.hasNext()) {
			Job currJob = itr.next();
			System.out.println("Job Name: " + currJob.getJobName() + "\n" +
					"Points earned for this job: " + currJob.getPoints() + "\n" +
					"--------------------------------------------");
		}//closes while loop
		
	}//closes displayScoreBoard

}//closes ScoreBoard class

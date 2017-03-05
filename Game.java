/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             Game.java
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
/**
 * This class is called by GameApp, creating jobs and ScoreBoard instances.
 * Contains the methods: getTimeToPlay, isOver, createJobs, getNumberOfJobs,
 * addJob, updateJob, displayActiveJobs, displayCompletedJobs, 
 * and getTotalScore.
 *
 * <p>Bugs: none that we are aware of
 *
 * @author Jon Sharp, Lindsey Bohr, Allison Quick, Michael Yang, Kendra Raczek
 */
public class Game{

	// A list of all jobs currently in the queue.
	private ListADT<Job> list;
	// Whenever a Job is completed it is added to the scoreboard
	private ScoreboardADT scoreBoard;
	//marker for amount of time left to play game
	private int timeToPlay;
	// declares a JobSimulator object
	private JobSimulator jobSimulator;

	/**
	 * Constructor. Initializes all variables.
	 * @param seed
	 * 		seed used to seed the random number generator in 
	 *		the Jobsimulator class.
	 * @param timeToPlay
	 * 		duration used to determine the length of the game.
	 */
	public Game(int seed, int timeToPlay){
		list = new JobList();
		this.timeToPlay = timeToPlay;
		jobSimulator = new JobSimulator(seed);
		scoreBoard = new Scoreboard();
	}//closes constructor

	/**
	 * Accessor method that returns the amount of time currently 
	 *		left in the game.
	 * @returns timeToPlay
	 *		the amount of time left in the game.
	 */
	public int getTimeToPlay() {
		return timeToPlay;
	}//closes getTimeToPlay()

	/**
	 * Mutator method that sets the amount of time that 
	 *		the game is to be executed for.
	 * Can be used to update the amount of time remaining.
	 * @param timeToPlay
	 *        the remaining duration of the game
	 */
	public void setTimeToPlay(int timeToPlay) {
		this.timeToPlay = timeToPlay;
	}//closes setTimeToPlay(int timeToPlay)

	/**
	 * States whether or not the game is over yet.
	 * @returns true 
	 *		iff the amount of time remaining 
	 *		in the game is less than or equal to 0
	 */
	public boolean isOver(){
		return timeToPlay <= 0;
	}//closes isOver()
	/**
	 * This method simply invokes the simulateJobs method
	 * in the JobSimulator object.
	 */
	public void createJobs(){
		jobSimulator.simulateJobs(list, timeToPlay);
	}//closes createJobs()

	/**
	 *This accessor method obtains the number of jobs in the ListNode
	 * @returns list.size()
	 *		the length of the Joblist.
	 */
	public int getNumberOfJobs(){
		return list.size();
	}//closes getNumberOfJobs()

	/**
	 * Adds a job to a given position in the JobList.
	 * Also requires to calculate the time penalty involved in
	 * adding a job back into the list and updates the timeToPlay
	 * accordingly
	 * @param pos
	 *      The position that the given job is to be added to in the list.
	 * @param item
	 *      The job to be inserted in the Listnode
	 */
	public void addJob(int pos, Job item){
		list.add(pos, item);
		timeToPlay -= pos;
	}//closes addJob(pos, item)

	/**
	 * Adds a job to the end end of the Listnode.
	 * @param item
	 *      The job to be inserted in the list.
	 */
	public void addJob(Job item){
		list.add(item);
	}//closes addJob(item)

	/**
	 * Given a valid index and duration,
	 * executes the given job for the given duration.
	 *
	 * This function should remove the job from the list and
	 * return it after applying the duration.
	 *
	 * This function should set duration equal to the
	 * amount of time remaining if duration exceeds it prior
	 * to executing the job.
	 * After executing the job for a given amount of time,
	 * check if it is completed or not. If it is, then
	 * it must be inserted into the scoreBoard.
	 * This method should also calculate the time penalty involved in
	 * executing the job and update the timeToPlay value accordingly
	 * @param index
	 *      The job to be inserted in the list.
	 * @param duration
	 *      The amount of time the given job is to be worked on for.
	 *@return updated
	 *		the updated Job that is removed from the ListNode
	 */
	public Job updateJob(int index, int duration){
		Job updated = list.remove(index);
		//set the timeToPlay to duration if it is less than duration
		if (timeToPlay <= duration) {
			duration = timeToPlay;
		}//closes if statement

		updated.setSteps(updated.getSteps() + duration);

		if (updated.isCompleted()) {
			scoreBoard.updateScoreBoard(updated);
		}//closes if statement
		//decrement timetoPlay by index and duration
		timeToPlay -= index;
		timeToPlay -= duration;
		return updated;
	}//closes updateJob(int index, int duration)

	/**
	 * This method produces the output for the initial Job Listing, IE:
	 * "Job Listing
	 *  At position: job.toString()
	 *  At position: job.toString()
	 *  ..."
	 *
	 */
	public void displayActiveJobs(){
		Iterator<Job> itr = list.iterator();
		int position = 0;
		System.out.println("Job Listing");
		//while the Listnode has a next node, 
		//print the positions and jobs
		while (itr.hasNext()) {
			Job currJob = itr.next();
			System.out.println("At position " + position + " " 
					   + currJob);
			position++;
		}//close while loop

	}//closes displayActiveJobs()

	/**
	 * This function simply invokes the displayScoreBoard 
	 *		method in the ScoreBoard class.
	 */
	public void displayCompletedJobs(){
		scoreBoard.displayScoreBoard();
	}//closes displayCompletedJobs()

	/**
	 * This function simply invokes the getTotalScore method of 
	 * the ScoreBoard class.
	 * @return scoreBoard.getTotalScore()
	 *		the value calculated by getTotalScore
	 */
	public int getTotalScore(){
		return scoreBoard.getTotalScore();
	} //closes getTotalScore()
} //closes Game class

/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             ScoreboardADT.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

	public interface ScoreboardADT {
		 /**
	     * Calculates the total combined number of points for every job in the scoreboard.
	     * 
	     * @return The summation of all the points for every job currently stored in the scoreboard.
	     */
		int getTotalScore();
		
		 /**
	     * Inserts the given job at the end of the scoreboard.
	     * 
	     * @param job 
	     * 		The job that has been completed and is to be inserted into the list.
	     */
	    void updateScoreBoard(Job job);
	
	    /**
	     * Prints out a summary of all jobs currently stored in the scoreboard. The formatting must match the example exactly.
	     */
	    void displayScoreBoard();
	}

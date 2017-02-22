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

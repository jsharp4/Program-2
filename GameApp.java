/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             GameApp.java
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

import java.util.Scanner;

/**
 * This class sets up the Game App.  Imports Scanner. This is the main class
 *that calls other methods to perform the game. Includes methods: main, start,
 *and getIntegerInput.
 * <p>Bugs: None that we are aware of
 *
 * @author Jon Sharp, Michael Yang, Lindsey Bohr, Allison Quick, Kendra Raczek
 */
public class GameApp{
	/**
	 * Scanner instance for reading input from console
	 */
	private static final Scanner STDIN = new Scanner(System.in);
	//declares a Game reference
	private Game game;

	/**
	 * Constructor for instantiating game class
	 * @param seed: Seed value as processed in command line
	 * @param timeToPlay: Total time to play from command line
	 */
	public GameApp(int seed, int timeToPlay){
		game = new Game(seed, timeToPlay);
	}//closes constructor

	/**
	 * Main function which takes the command line arguments and 
	 * instantiate the GameApp class.
	 * The main function terminates when the game ends.
	 * Use the getIntegerInput function to read inputs from console
	 * @throws NumberFormatException
	 *	when the seed or timeToPlay is 0 or negative
	 * @param args: Command line arguments <seed> <timeToPlay>
	 */
	public static void main(String[] args){

		System.out.println("Welcome to the Job Market!");
		//try and catch blocks used to catch NumberFormatException
		try {
			int seed = Integer.parseInt(args[0]);
			int timeToPlay = Integer.parseInt(args[1]);

			if (seed <= 0 || timeToPlay <= 0) {
				throw new NumberFormatException();
			} //closes if statement	
			GameApp app = new GameApp(seed, timeToPlay);
			app.start();
		} catch (NumberFormatException e) {
			System.out.
				print("Invalid command line input. Goodbye.");
		} //closes catch

	} //closes main(String[] args)

	/**
	 * This method is called by main to start the game and runs until the 
	 * game is over. It calls the game's class and it allows for the 
	 * creation of jobs.
	 */
	private void start(){
		//while the game is not over, run the following
		while(!game.isOver()) {
			System.out.println("You have " + game.getTimeToPlay() 
					   + " left in the game!");
			game.createJobs();
			game.displayActiveJobs();
			int jobIndex = 
				getIntegerInput("Select a job to work on: ");
			while (jobIndex < 0 || jobIndex 
			       >= game.getNumberOfJobs()) {
				jobIndex = getIntegerInput
					("Invalid position. "
					 + "Select a job to work on: ");
			} //close while loop
			System.out.println(jobIndex);
			
			int workTime = getIntegerInput("For how long would 
					   + "you like to work on this job?: ");
			while (workTime < 0) {
				workTime = getIntegerInput("Please enter a" 
					 + " non-negative duration of time to" 
					 + " work on this job: ");
			} //close while loop
			System.out.println(workTime);

			Job currJob = game.updateJob(jobIndex, workTime);
			if (!currJob.isCompleted()) {
				int returnIndex = getIntegerInput("At what position"
						+ " would you like to insert the job"
						+ " back into the list?\n");
				System.out.println(returnIndex);
				if (returnIndex < 0 || returnIndex 
				    		> game.getNumberOfJobs()) {
					returnIndex = game.getNumberOfJobs();
				} //closes inner if statement 
				game.addJob(returnIndex, currJob);
			} //closes outer if statement
			else {
				System.out.println("Job completed! Current Score: " 
						   + game.getTotalScore());
				System.out.println("Total score: " 
						   + game.getTotalScore());
				game.displayCompletedJobs();
			} //closes else statement
		} //closes while loop
		System.out.println("Game Over!\nYour final score: " 
				   + game.getTotalScore());
	} //closes start()

	/**
	 * Displays the prompt and returns the integer entered by the user
	 * to the standard input stream.
	 *
	 * Does not return until the user enters an integer.
	 * Does not check the integer value in any way.
	 * @param prompt 
	 * 	The user prompt to display before waiting for this integer.
	 * @return STDIN.nextInt()
	 *	the next integer that is entered
	 */
	public static int getIntegerInput(String prompt) {
		System.out.print(prompt);
		while ( ! STDIN.hasNextInt() ) {
			System.out.print(STDIN.next()+ " is not an int. " 
					 + "Please enter an integer.");
		} //closes while loop
		return STDIN.nextInt();
	} //closes getIntegerInput(prompt)
	
} //closes GameApp

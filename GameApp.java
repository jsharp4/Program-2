/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017
// PROJECT:          Program 2
// FILE:             GameApp.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Jon Sharp, Lindsey Bohr, Allison Quick
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
// Author4: Michael Yang, yang363@wisc.edu, yang363, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;

public class GameApp{
	/**
	 * Scanner instance for reading input from console
	 */
	private static final Scanner STDIN = new Scanner(System.in);
	private Game game;

	/**
	 * Constructor for instantiating game class
	 * @param seed: Seed value as processed in command line
	 * @param timeToPlay: Total time to play from command line
	 */
	public GameApp(int seed, int timeToPlay){
		game = new Game(seed, timeToPlay);
	}

	/**
	 * Main function which takes the command line arguments and instantiate the
	 * GameApp class.
	 * The main function terminates when the game ends.
	 * Use the getIntegerInput function to read inputs from console
	 *
	 * @param args: Command line arguments <seed> <timeToPlay>
	 */
	public static void main(String[] args){

		System.out.println("Welcome to the Job Market!");
		
		try {
			int seed = Integer.parseInt(args[0]);
			int timeToPlay = Integer.parseInt(args[1]);

			if (seed <= 0 || timeToPlay <= 0) {
				throw new NumberFormatException();
			} 	
			GameApp app = new GameApp(seed, timeToPlay);
			app.start();
		} catch (NumberFormatException e) {
			System.exit(0);;
		}

		//TODO: Take input from command line, process it and add error checking
		//TODO: Call the start() method to start playing the game
	}

	/**
	 * Add Comments as per implementation
	 */
	private void start(){
		//TODO: The interactive game logic goes here
		while(!game.isOver()) {
			System.out.println("You have " + game.getTimeToPlay() + " left in the game!");
			game.createJobs();
			game.displayActiveJobs();
			int jobIndex = getIntegerInput("Select a job to work on: ");
			int workTime = getIntegerInput("For how long would you like to work on "
					+ "this job?: ");
			//game.setTimeToPlay(game.getTimeToPlay() - jobIndex);

			Job currJob = game.updateJob(jobIndex, workTime);
			if (!currJob.isCompleted()) {
				int returnIndex = getIntegerInput("At what position would you like "
						+ "to insert the job back into the list?\n");
				if (returnIndex < 0 || returnIndex > game.getNumberOfJobs()) {
					returnIndex = game.getNumberOfJobs();
				}
				game.addJob(returnIndex, currJob);
				game.setTimeToPlay(game.getTimeToPlay() - returnIndex);
			}
			else {
				System.out.println("Job completed! Current Score: " + game.getTotalScore());
				System.out.println("Total score: " + game.getTotalScore());
				game.displayCompletedJobs();
			}
		}
		System.out.println("Game Over!\nYour final score: " + game.getTotalScore());
		

	}

	/**
	 * Displays the prompt and returns the integer entered by the user
	 * to the standard input stream.
	 *
	 * Does not return until the user enters an integer.
	 * Does not check the integer value in any way.
	 * @param prompt The user prompt to display before waiting for this integer.
	 */
	public static int getIntegerInput(String prompt) {
		System.out.print(prompt);
		while ( ! STDIN.hasNextInt() ) {
			System.out.print(STDIN.next()+" is not an int.  Please enter an integer.");
		}
		return STDIN.nextInt();
	}
}

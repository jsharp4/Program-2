import java.util.Random;

/**
 *  No changes are required for this class
 *  ***************************************************************
 *
 *  The JobList class must be implemented for the simulator to work
 *
 *  The Simulator needs to be instantiated from the GAME class
 *
 *  The createJobs function from Game class will be invoking the
 *  public function simulateJobs
 *
 *  This program probabilistically creates large number of small jobs or small number of large jobs
 *
 *  The @param seed can be used for DEBUGGING purposes, which can be sent as command line
 *  from the main class. If the seed is set to 0, then the simulator behaves purely randomly
 *
 *  The parameters for generating jobs can also be tweeked using the Config.java file
 *  for understanding the simulator and to better test your program
 *
*/
public class JobSimulator{
    /**
     * Counter: This keeps a global count of the number of jobs created
     * and names the jobs accordingly
     *
     * generator: instance used for generating random numbers
     * More on generating random numbers can be read here:
     * https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
     */
    private int counter;
    private Random generator;

    /**
     * Constructor for JobSimulator
     * @param seed: seed from command line
     *            for debugging purposes
     */
    public JobSimulator(int seed) {
        this.counter = 0;
        if(seed != 0)
            generator = new Random(seed);
        else
            generator = new Random(System.currentTimeMillis());

    }

    /**
     * This function create a bunch of jobs at random
     * and appends it to the end of the list of jobs.
     * Probabilistically create small or large jobs
     * The parameters can be changed by using the values in Config file
     *
     * @param list: The list of jobs in the game
     * @param timeUnits: For the first time simulate jobs is called
     *                 this is the timeToPlay value
     *                 Later this can be used to send the timeUnits of the
     *                 current job in execution
     */

    public void simulateJobs(ListADT<Job> list, int timeUnits){

      int jobType = generator.nextInt(Config.HIGH- Config.LOW);

        if(jobType > Config.PROBABILITY_OF_JOB_TYPE)
           createSmallJobs(list, timeUnits);
       else
           createLargeJobs(list, timeUnits);

   }

    /**
     * Private method for create large jobs with higher points,
     * requiring more time to complete
     * @param list: The list of jobs
     * @param timeUnits: Timeunit of the current job in execution
     */
    private void createLargeJobs(ListADT<Job> list, int timeUnits) {
        while(timeUnits > 0){
            int random = generator.nextInt(Config.HIGH - Config.LOW);
            if(random > Config.PROBABILITY_OF_LARGE_JOB_CREATION){
                String name = "J"+this.counter;
                int timeUnit = (Math.abs(generator.nextInt()) % timeUnits) + 1;
                int points = timeUnit * ((Math.abs(generator.nextInt())) % 50);
                Job newjob = new Job(name, points, timeUnit);
                this.counter++;
                list.add(newjob);
                timeUnits = timeUnits - Config.LARGE_JOB_INTERVAL;
            }
        }

    }

    /**
     * Private method for creating small jobs with lower points and
     * requires lesser time to complete
     * @param list: The list of jobs
     * @param timeUnits: Time Units of the current job in execution
     */
    private void createSmallJobs(ListADT<Job> list, int timeUnits) {
        while(timeUnits > 0){
            int random =  generator.nextInt(Config.HIGH-Config.LOW);

            if(random > Config.PROBABILITY_OF_SMALL_JOB_CREATION){
                String name = "J"+this.counter;
                int timeUnit = (Math.abs(generator.nextInt()) % timeUnits) + 1;
                int points = timeUnit * ((Math.abs(generator.nextInt())) % 100);
                Job newjob = new Job(name, points, timeUnit);
                this.counter++;
                list.add(newjob);
                timeUnits = timeUnits - Config.SMALL_JOB_INTERVAL;
            }
        }
    }
}
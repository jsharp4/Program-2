/**
 * No changes are required in this class
 *
 * This class contains the class definition for a job
 * Contains variables which define a job including
 *
 * jobName: Is of the format J0, J1... and is assigned automatically
 * by the job simulator.
 *
 * steps: percentage of job completed in the game at a given point
 * of time.
 *
 * points: Total number of points awarded when the job is completed
 *
 * timeUnits: Total timeunits required to complete the job
 *
 * The class includes getter and setter methods
 * and the toString function to print out the job details.
 *
 */
public class Job{
    /** Member variables of the job class
     */
    private String jobName;
    private int steps;
    private int points;
    private int timeUnits;

    /**
     * Constructor for instantiating a job
     * @param jobName :Is of the format J0, J1... and is assigned automatically
     * by the job simulator.
     * @param points :percentage of job completed in the game at a given point
     * of time.
     * @param timeUnits :Total timeunits required to complete the job
     */
    public Job(String jobName, int points, int timeUnits) {
        this.jobName = jobName;
        this.points = points;
        this.timeUnits = timeUnits;
    }

    /**
     * Function to validate if a job has been completed
     * @return: true if job has been completed
     *          false otherwise
     */
    public boolean isCompleted() {
        return timeUnits == steps;
    }

    /**
     * Getter for jobName
     * @return: jobName
     */

    public String getJobName() {
        return jobName;
    }

    /**
     * Setter for jobName. Used only by the simulator
     * @param jobName: jobname for a given job
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * getter for steps completed in the given job
     * @return : steps
     */

    public int getSteps() {
        return steps;
    }

    /**
     * Setter for steps completed in the given job
     * @param steps: percentage of job completed
     */

    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * getter for number of points associated with a given job
     * @return: points
     */

    public int getPoints() {
        return points;
    }

    /**
     * Setter for the points associated with a given job
     * @param points: set the points for a job
     */

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Getter for the total time required to complete the job
     * @return : timeUnits
     */

    public int getTimeUnits() {
        return timeUnits;
    }

    /**
     * Setter for the timeUnits required to complete a job
     * @param timeUnits
     */

    public void setTimeUnits(int timeUnits) {
        this.timeUnits = timeUnits;
    }

    /**
     * Converts the job instance into a format which can be displayed.
     * @return: String format for job
     */
    public String toString(){
        return "Job Name: " + jobName + " Job Points: " + points + " Steps Remaining: "+ (this.timeUnits - this.steps);
    }
}
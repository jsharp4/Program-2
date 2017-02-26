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

package scheduling;

import java.util.List;

/**
 * This class implements the SJF scheduler; 
 * SJF = Shortest Job First. 
 * Ties are broken alphabetically.
 */
public class SJFScheduler extends Scheduler {
    /**
     * To make a scheduler, you need a list of jobs.
     */
    public SJFScheduler(List<JobInfo> jobs) {
        super(jobs);
    }

    /**
     * How do we pick the first job?
     */
    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        JobInfo min = current.get(0);
        for (JobInfo j : current) {
            if (j.getDuration() < min.getDuration()) {
                min = j;
            } else if (j.getDuration() == min.getDuration()) {
                if (j.getName().compareTo(min.getName()) < 0) {
                    min = j;
                }
            }
        }
        return min;
    }
}
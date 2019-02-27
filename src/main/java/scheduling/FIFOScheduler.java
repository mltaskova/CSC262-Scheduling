package scheduling;

import java.util.Collections;
import java.util.List;

/**
 * This class implements the FIFO or FCFS scheduler; 
 * FIFO = First job in-first job out. 
 * Ties are broken alphabetically.
 */
public class FIFOScheduler extends Scheduler {
    /**
     * To make a scheduler, you need a list of jobs.
     */
    public FIFOScheduler(List<JobInfo> jobs) {
        super(jobs);
    }

    /**
     * How do we pick the first job?
     */
    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        JobInfo min = current.get(0);
        for (JobInfo j : current) {
            if (j.getArrivalTime() < min.getArrivalTime()) {
                min = j;
            } else if (j.getArrivalTime() == min.getArrivalTime()) {
                if (j.getName().compareTo(min.getName()) < 0) {
                    min = j;
                }
            }
        }
        return min;
    }
}
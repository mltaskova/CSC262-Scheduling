package scheduling;

import java.util.List;

/**
 * Created by mltaskova on 3/14/19.
 */
public class PMLQScheduler extends Scheduler {
    /**
     * @param jobs the list of job information from the file.
     */
    public PMLQScheduler(List<JobInfo> jobs) {
        super(jobs);
    }

    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        return null;
    }
}

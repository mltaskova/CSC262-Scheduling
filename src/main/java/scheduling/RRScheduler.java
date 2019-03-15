package scheduling;

import java.util.Collections;
import java.util.List;

/**
 * Created by mltaskova on 3/14/19.
 */
public class RRScheduler extends Scheduler {
    /**
     * @param jobs the list of job information from the file.
     */
    public RRScheduler(List<JobInfo> jobs) {
        super(jobs);
    }

    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        return Collections.min(current, new ByRR());
    }
}

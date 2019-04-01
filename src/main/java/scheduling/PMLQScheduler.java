package scheduling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mltaskova on 3/14/19.
 */
public class PMLQScheduler extends Scheduler {

    List<List<JobInfo>> queue;
    /**
     * @param jobs the list of job information from the file.
     */
    public PMLQScheduler(List<JobInfo> jobs, int level, double prob) {
        super(jobs);
        queue = new ArrayList<>(level);
        for (int i = 0; i < level; i++){
            queue.add(new ArrayList<>());
        }
    }

    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        for (int i =0; i < queue.size(); i++){
            if (queue.get(i).size() >0)
                return null;
        }
        return null;
    }
}

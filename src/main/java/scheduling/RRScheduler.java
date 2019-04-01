package scheduling;

import java.util.Collections;
import java.util.List;

/**
 * Created by mltaskova on 3/14/19.
 */
public class RRScheduler extends Scheduler {

    private JobInfo last;
    /**
     * @param jobs the list of job information from the file.
     */
    public RRScheduler(List<JobInfo> jobs) {
        super(jobs);
        last = new JobInfo("", 0, 0);
    }

    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        if (last.getName().equals("")){
            return Collections.min(current, new ByArrivalTime());
        }
        else {
            Collections.sort(current, new ByArrivalTime());
            boolean next = false;
            for (JobInfo job : current){
                if (next)
                    return job;
                else if (job.getName().equals(last.getName()))
                    next = true;
            }
            return Collections.min(current);
        }
    }

    @Override
    public void run(){
        while (!isDone()){
            JobInfo job = chooseJob(jobsAvailableNow());
            for (int i = 0; i < 5; i++){
                time.add(job.getName());
                job.runSingleStep();
                last = job;
            }
            for (JobInfo temp : jobsAvailableNow()){
                for (int i = 0; i < 5; i++){
                    temp.incrementTimeFinished();
                }
            }
        }
    }
}

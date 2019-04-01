package scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mltaskova on 3/14/19.
 */
public class DurationLotteryScheduler extends Scheduler {

    private double totalWeight;
    /**
     * @param jobs the list of job information from the file.
     */
    public DurationLotteryScheduler(List<JobInfo> jobs) {
        super(jobs);
        totalWeight = 0.0;
    }

    public List<Double> getWeights(List<JobInfo> current){
        List<Double> weights = new ArrayList<>();
        totalWeight = 0;
        for (JobInfo job : current){
            totalWeight += (double) job.getDuration();
            weights.add(totalWeight);
        }
        return weights;
    }

    @Override
    public JobInfo chooseJob(List<JobInfo> current) {
        double x = Math.random();
        List<Double> weights = getWeights(current);
        double temp;
        for (int i = 0; i < current.size(); i++){
            temp = weights.get(i);
            if (temp/totalWeight > x){
                return current.get(i);
            }
        }
        return null;
    }
}

package scheduling;

import java.util.Comparator;

/**
 * Created by mltaskova on 3/14/19.
 */
public class ByArrivalTime implements Comparator<JobInfo> {

    @Override
    public int compare(JobInfo o1, JobInfo o2) {
        return Integer.compare(o1.getArrivalTime(), o2.getArrivalTime());
    }
}

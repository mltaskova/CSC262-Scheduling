package scheduling;

import java.util.Comparator;

/**
 * Created by mltaskova on 3/14/19.
 */
public class ByDuration implements Comparator<JobInfo> {
    @Override
    public int compare(JobInfo o1, JobInfo o2) {
        return Integer.compare(o1.getDuration(), o2.getDuration());
    }
}

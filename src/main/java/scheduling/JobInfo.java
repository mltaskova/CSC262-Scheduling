package scheduling;

public class JobInfo implements Comparable<JobInfo> {
    /** What is this job called? */
    private String name;
    /** What time does this job arrive? */
    private int arrivalTime;
    /** How long will this job run? */
    private int duration;

    /** How long has this job run so far? */
    private int timeRun;

    private int timeFinished;

    /**
     * Construct a new job specification:
     */
    public JobInfo(String name, int arrivalTime, int duration) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.timeRun = 0;
        this.timeFinished = 0;
    }
    
    /** Get the name of this job. */
    public String getName() {
        return this.name;
    }

    /**
     * Copy this job, ignoring "timeRun!"
     */
    public JobInfo copy() {
        return new JobInfo(this.name, this.arrivalTime, this.duration);
    }

    /** Has the job arrived at time "now"? */
    public boolean hasArrived(int now) {
        return this.arrivalTime <= now;
    }

    /** Is this job done? */
    public boolean hasFinished() {
        return this.duration <= this.timeRun;
    }

    /** Update this job's time spent running. */
    public void runSingleStep() {
        this.timeRun++;
    }

    public int getTimeRun(){ return timeRun; }

    public void incrementTimeFinished(){
        this.timeFinished++;
    }

    public int getTimeFinished(){
        return  this.timeFinished;
    }

    /** 
     * Arrival time getter. 
     * @return the arrivalTime
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Duration of the job.
     * @return the duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Order by arrival time and then by name!
     */
    @Override
    public int compareTo(JobInfo o) {
        int byArrival = Integer.compare(this.arrivalTime, o.arrivalTime);
        if (byArrival == 0) {
            return this.name.compareTo(o.name);
        }
        return byArrival;
    }
}
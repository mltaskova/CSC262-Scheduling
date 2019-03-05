# CSC262-Scheduling
P1.R: Idealized Scheduler Implementation Sandbox

## Example Input File: (fig_7_4.jobs)

```
job A 0 100
job B 10 10
job C 10 10
```

The input file contains a sequence of lines specifying a JobInfo class object:

-	``job A 0 100``
-	``name = "A"``
-	``arrivalTime = 0``
- ``duration = 100``

## Rubric

### README (20 points):

-	Tell me how to build and run your program.
-	Give me an input file that you have used (not one of mine).

### Functionality (80 points):

The simulation should run every scheduler and print its results in order.

-	(10) Comparator<JobInfo> for FIFO and SJF.
    - FIFO is implemented by hand right now. What about using sort or min?
- (10) Create a "STCF" Scheduler.
- (10) Create a "RoundRobin" Scheduler.
- (20) Create a "DurationLottery" scheduler.
    -	Random sampling of next job must be correct.
    - Worksheet #4, #5.
- (20) Create a "ProbabilityMultiLevelQueue" Scheduler
    - Jobs move down after being scheduled with probability ***p***.
    - There are ***k*** levels.
    - Parameters ***p*** and ***k*** must be configurable.
- (10) Compute average turnaround time after a simulation is run.

### Extra Credit Opportunities:

- Do (some of) it again, but in plain C.
- Try outputting HTML tables or SVG for automatically generating snazzy diagrams.
- Generate input files automatically.
- The schedulers run are configurable part of the input.

package scheduling;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;

/**
 * This class reads input and runs the simulation.
 */
public class Main {
  /**
   * Crash with an error message.
   */
  public static void die(String message) {
    throw new RuntimeException(message);
  }

  /**
   * Parse to int or crash with an error message.
   */
  public static int intOrDie(String data) {
    try {
      return Integer.parseInt(data);
    } catch(NumberFormatException nfe) {
      throw new RuntimeException("Couldn't make "+data+" into an int.", nfe);
    }
  }

  /**
   * Main entry point.
   */
  public static void main(String[] args) throws IOException {
    String inputPath = "input.txt";
    double prob = 0.0;
    int levels = 0;
    if (args.length == 1){
      inputPath = args[0];
    }
    else if (args.length == 3) {
      inputPath = args[0];
      prob = Double.valueOf(args[1]);
      levels = Integer.valueOf(args[2]);
    }

    // Build up a list of jobs from reading the file.
    List<JobInfo> jobs = new ArrayList<>();

    // Loop through every line and parse out the job description.
    for (String line : Files.readAllLines(new File(inputPath).toPath())) {
      String[] data = line.trim().split("\\s+");
      // skip blank lines
      if (data.length == 0) {
        continue;
      }
      // require four fields
      if (data.length != 4) {
        die("Unknown line length: "+line);
      }
      if (data[0].equals("job")) {
        JobInfo job = new JobInfo(data[1], intOrDie(data[2]), intOrDie(data[3]));
        jobs.add(job);
      } else {
        die("Unknown line: "+line);
      }
    }

    // Create a scheduler.
    for (Scheduler sched : Arrays.asList(
      new FIFOScheduler(jobs),
      new SJFScheduler(jobs),
      new STCFScheduler(jobs),
      new RRScheduler(jobs),
      new DurationLotteryScheduler(jobs)
    )) {
      sched.run();
      sched.printStats(sched.getClass().getSimpleName());
    }
  }
}

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static double CONFIDENCE_95 = 1.96;
    private final int t;

    private final double[] percolationCounter;
    private final double mean;
    private final double stddev;
    private final double sqrtT;

    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        if (n <= 0) {
            throw new IllegalArgumentException("n should be > 0");
        }

        if (trials <= 0) {
            throw new IllegalArgumentException("n should be > 0");
        }

        t = trials;
        Percolation percolation;
        int row, col, counter;
        percolationCounter = new double[trials];

        for (int trial = 0; trial < trials; trial++) {
            percolation = new Percolation(n);
            counter = 0;

            while (!percolation.percolates()) {
                do {
                    row = StdRandom.uniform(1, n + 1);
                    col = StdRandom.uniform(1, n + 1);
                } while (percolation.isOpen(row, col));

                percolation.open(row, col);
                counter++;
            }

            percolationCounter[trial] = (double) counter/(n * n);
        }

        mean = StdStats.mean(percolationCounter);
        stddev = StdStats.stddev(percolationCounter);
        sqrtT = Math.sqrt(t);
    }
    public double mean()                          // sample mean of percolation threshold
    {
        return mean;
    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        return stddev;
    }

    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        return mean() - ((CONFIDENCE_95 * stddev())/ sqrtT);
    }

    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        return mean() + ((CONFIDENCE_95 * stddev())/ sqrtT);
    }

    public static void main(String[] args)        // test client (described below)
    {
        PercolationStats stats = new PercolationStats(200, 100);

        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}
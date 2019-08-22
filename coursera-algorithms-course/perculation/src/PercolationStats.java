import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE = 1.96;
    private final double[] perlocationTreshold;
    private final int trials;
    private double mean;
    private double stddev;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.trials = trials;
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        perlocationTreshold = new double[trials];

        for (int trial = 0; trial < trials; trial++) {
            int[] randomOrderToOpen = StdRandom.permutation(n * n);
            Percolation percolation = new Percolation(n);
            for (int indexToOpen : randomOrderToOpen) {
                int row = toRow(n, indexToOpen);
                int column = toColumn(n, indexToOpen);
                percolation.open(row, column);
                if (percolation.percolates()) {
                    perlocationTreshold[trial] = (double) percolation.numberOfOpenSites() / (double) (n * n);
                    break;
                }
            }
        }
        this.mean = StdStats.mean(perlocationTreshold);
        this.stddev = StdStats.stddev(perlocationTreshold);
    }

    private int toColumn(int n, int indexToOpen) {
        return indexToOpen - ((indexToOpen / n) * n) + 1;
    }

    private int toRow(int n, int indexToOpen) {
        return (indexToOpen / n) + 1;
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE * stddev()) / Math.sqrt(trials));
    }


    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE * stddev()) / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.printf("mean                          = %s\n", stats.mean());
        StdOut.printf("stddev                        = %s\n", stats.stddev());
        StdOut.printf("95%% confidence interval      = [%s, %s]\n", stats.confidenceLo(), stats.confidenceHi());
    }

}

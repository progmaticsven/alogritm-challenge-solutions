import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[] sites;
    private final int gridSize;
    private int openCount;
    private final WeightedQuickUnionUF qf;
    private final WeightedQuickUnionUF qf2;
    private final int bottomRootIndex;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        int qfTreeSize = n * n + 2;
        this.sites = new boolean[qfTreeSize];
        this.qf = new WeightedQuickUnionUF(qfTreeSize);

        this.qf2 = new WeightedQuickUnionUF(qfTreeSize);

        this.bottomRootIndex = qfTreeSize - 1;

        for (int i = 0; i < n; i++) {
            this.qf.union(0, i + 1);
            this.qf2.union(0, i + 1);
            this.qf.union(bottomRootIndex, bottomRootIndex - i - 1);
        }

        this.gridSize = n;
    }

    private void validateRowAndColumn(int row, int col) {
        if (row <= 0 || col <= 0 || row > gridSize || col > gridSize) throw new IllegalArgumentException();
    }

    public void open(int row, int col) {
        validateRowAndColumn(row, col);

        if(isOpen(row, col)) return;

        int index = toGridIndex(row, col);
        if (!sites[index]) {
            this.openCount++;
        }
        if (col > 1 && isOpen(row, col - 1)) {
            this.qf.union(index, toGridIndex(row, col - 1));
            this.qf2.union(index, toGridIndex(row, col - 1));
        }

        if (col < gridSize && isOpen(row, col + 1)) {
            this.qf.union(index, toGridIndex(row, col + 1));
            this.qf2.union(index, toGridIndex(row, col + 1));
        }

        if (row > 1 && isOpen(row - 1, col)) {
            this.qf.union(index, toGridIndex(row - 1, col));
            this.qf2.union(index, toGridIndex(row - 1, col));
        }

        if (row < gridSize && isOpen(row + 1, col)) {
            this.qf.union(index, toGridIndex(row + 1, col));
            this.qf2.union(index, toGridIndex(row + 1, col));
        }

        sites[index] = true;
    }

    public boolean isOpen(int row, int col) {
        validateRowAndColumn(row, col);
        return sites[toGridIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        validateRowAndColumn(row, col);
        return isOpen(row, col)
                && qf.connected(0, toGridIndex(row, col))
                && qf2.connected(0, toGridIndex(row, col));
    }

    private int toGridIndex(int row, int col) {
        return ((row - 1) * gridSize) + col;
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    public boolean percolates() {
        if(openCount > 0){
            return qf.connected(0, bottomRootIndex);

        }
        return false;
    }
}

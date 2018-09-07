import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private final WeightedQuickUnionUF quickFindUF;
    private int numberSitesOpen = 0;
    private final byte[][] moves = new byte[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    private boolean[][] openSites;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n)
    {
        if (n <= 0) {
            throw new IllegalArgumentException("n should be > 0");
        }
        this.n = n;
        this.quickFindUF = new WeightedQuickUnionUF(n * n + 1);
        this.openSites = new boolean[n][n];
    }

    private int mapPosition(int row, int col) {
        return (row - 1) * n + col;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if (row > n || row < 1) {
            throw new IllegalArgumentException("row should be > 0");
        }

        if (col > n || col < 1) {
            throw new IllegalArgumentException("col should be > 0");
        }

        if (!openSites[row - 1][col - 1]) {
            openSites[row - 1][col - 1] = true;
            numberSitesOpen++;
        }
        int moveRow, moveCol;

        for (byte[] move: moves) {
            moveRow = row + move[0];
            moveCol = col + move[1];

            if (moveRow > 0 && moveCol > 0 && moveRow <= n && moveCol <= n && openSites[moveRow - 1][moveCol - 1]) {
                quickFindUF.union(mapPosition(row, col), mapPosition(moveRow, moveCol));
            }
        }

        if (row == 1) {
            this.quickFindUF.union(0, mapPosition(row, col));
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if (row > n || row <= 0) {
            throw new IllegalArgumentException("row should be > 0");
        }

        if (col > n || col <= 0) {
            throw new IllegalArgumentException("col should be > 0");
        }

        return openSites[row - 1][col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if (row > n || row <= 0) {
            throw new IllegalArgumentException("row should be > 0 and < n + 1");
        }

        if (col > n || col <= 0) {
            throw new IllegalArgumentException("col should be > 0 and < n + 1");
        }

        return this.quickFindUF.connected(0, mapPosition(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numberSitesOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < n; i++) {
            if (openSites[n - 1][i] && this.quickFindUF.connected(0, mapPosition(n, i + 1))) {
                return true;
            }
        }

        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        System.out.println("Percolation");
    }
}
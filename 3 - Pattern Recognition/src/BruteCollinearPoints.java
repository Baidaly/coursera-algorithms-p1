import edu.princeton.cs.algs4.In;

public class BruteCollinearPoints {
    LineSegment[] segments;
    int segmentsCount = 0;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new java.lang.IllegalArgumentException("Argumet cannot be null");
        }

        segments = new LineSegment[points.length];

        for (int c1 = 0; c1 < points.length - 1; c1++) {
            for (int c2 = c1; c2 < points.length - 1; c2++) {
                for (int c3 = c2; c3 < points.length - 1; c3++) {
                    for (int c4 = c3; c4 < points.length - 1; c4++) {
                        if (points[c1].slopeTo(points[c2]) == points[c1].slopeTo(points[c3]) &&
                                points[c1].slopeTo(points[c3]) == points[c3].slopeTo(points[c4])) {
                            segments[segmentsCount] = new LineSegment(points[c1], points[c4]);
                            segmentsCount++;
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segmentsCount;
    }

    // the line segments
    public LineSegment[] segments() {
        return segments;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);      // input file
        int n = in.readInt();         // n
        int i = 0;
        Point[] points = new Point[n];

        while (!in.isEmpty()) {
            int x = in.readInt();
            int y = in.readInt();

            points[i] = new Point(x, y);

            i++;
        }
    }
}
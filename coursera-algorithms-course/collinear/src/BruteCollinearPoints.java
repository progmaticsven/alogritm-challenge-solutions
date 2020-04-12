import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {
  private LineSegment[] segments;

  public BruteCollinearPoints(Point[] points) {
    if (points == null) {
      throw new IllegalArgumentException("Null argument");
    }

    for (int k = 0; k < points.length; k++) {
      for (int l = 0; l < points.length; l++) {
        if (k != l && points[k].compareTo(points[l]) == 0) {
          throw new IllegalArgumentException("Repeated argument");
        }
      }
    }

    List<LineSegment> list = new ArrayList<>();
    for (Point l1 : points) {
      for (Point l2 : points) {
        if (l2.compareTo(l1) > 0) {
          for (Point l3 : points) {
            if (l3.compareTo(l2) > 0) {
              for (Point l4 : points) {
                if (l4.compareTo(l3) > 0) {
                  double slope1 = l1.slopeTo(l2);
                  if (slope1 == l2.slopeTo(l3) && l3.slopeTo(l4) == slope1) {
                    list.add(new LineSegment(l1, l4));
                  }
                }
              }
            }
          }
        }
      }
    }
    this.segments = list.toArray(new LineSegment[list.size() - 1]);
  }

  public int numberOfSegments() {
    return segments.length;
  }

  public LineSegment[] segments() {
    return segments;
  }
}

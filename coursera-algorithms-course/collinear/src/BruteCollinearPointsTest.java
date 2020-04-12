import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BruteCollinearPointsTest {
  @Test
  public void oneCollinear() {
    BruteCollinearPoints points = new BruteCollinearPoints(
      new Point[]{
        new Point(0, 0),
        new Point(1, 1),
        new Point(2, 2),
        new Point(3, 3)
      });

    assertEquals(1, points.numberOfSegments());
  }

  @Test
  public void twoCollinear() {
    BruteCollinearPoints points = new BruteCollinearPoints(
      new Point[]{
        new Point(0, 0),
        new Point(1, 1),
        new Point(2, 2),
        new Point(3, 3),

        new Point(1, 5),
        new Point(2, 5),
        new Point(3, 5),
        new Point(8, 5)
      });

    assertEquals(2, points.numberOfSegments());
  }
}
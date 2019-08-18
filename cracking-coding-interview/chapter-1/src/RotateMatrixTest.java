import org.junit.Test;

import static org.junit.Assert.*;

public class RotateMatrixTest {

    @Test
    public void rotateMatrixClockwise2x2() {
        assertArrayEquals(
                new int[][]{
                        {3, 1},
                        {4, 2}
                },
                RotateMatrix.rotateMatrix(new int[][]{{1, 2}, {3, 4}})
        );

    }

    @Test
    public void rotateMatrixClockwise3x3() {
        assertArrayEquals(
                new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3},
                },
                RotateMatrix.rotateMatrix(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9},
                        })
        );
    }


    @Test
    public void rotateMatrixClockwise4x4() {
        assertArrayEquals(
                new int[][]{
                        {13, 9, 5, 1},
                        {14, 10, 6, 2},
                        {15, 11, 7, 3},
                        {16, 12, 8, 4},
                },
                RotateMatrix.rotateMatrix(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16},
                        })
        );

    }
}
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ZeroMatrixTest {

    @Test
    public void zeroWhenCellIsZero() {
        assertArrayEquals(
                new int[][]{{0,0}, {0, 1}},
                ZeroMatrix.zeroWhenCellIsZero(new int[][]{{0,1}, {1, 1}})
        );

        assertArrayEquals(
                new int[][]{{0,0}, {0, 0}},
                ZeroMatrix.zeroWhenCellIsZero(new int[][]{{0,0}, {0, 0}})
        );

        assertArrayEquals(
                new int[][]{{1,1}, {1, 1}},
                ZeroMatrix.zeroWhenCellIsZero(new int[][]{{1,1}, {1, 1}})
        );

        assertArrayEquals(
                new int[][]{{1,0}, {0, 0}},
                ZeroMatrix.zeroWhenCellIsZero(new int[][]{{1,1}, {1, 0}})
        );
    }


}
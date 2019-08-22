import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void backwash() {
        Percolation percolation = new Percolation(3);

        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);

        percolation.open(3, 1);
        assertTrue(percolation.percolates());

        assertFalse(percolation.isFull(3, 1));

    }

    @Test
    public void test200x200Init(){
        Percolation percolation = new Percolation(200);
        assertFalse(percolation.percolates());
        assertEquals(0, percolation.numberOfOpenSites());

        for(int row = 1; row <= 200; row++){
            for(int col = 1; col <= 200; col++){
                assertFalse(percolation.isFull(row, col));
                assertFalse(percolation.isOpen(row, col));

                percolation.open(row, col);

                assertTrue(percolation.isOpen(row, col));
                assertTrue(percolation.isFull(row, col));
            }
        }
        assertTrue(percolation.percolates());
        assertEquals(200*200, percolation.numberOfOpenSites());
    }

    @Test
    public void test200x200Edges(){
        Percolation percolation = new Percolation(200);
        assertFalse(percolation.percolates());

        for(int row = 1; row <= 199; row++){
            assertFalse(percolation.isOpen(row, 1));
            assertFalse(percolation.isFull(row, 1));

            assertFalse(percolation.isOpen(row, 1));
            assertFalse(percolation.isFull(row, 200));

            percolation.open(row, 1);
            percolation.open(row, 200);
            assertFalse(percolation.percolates());

            assertTrue(percolation.isFull(row, 1));
            assertTrue(percolation.isFull(row, 200));

            assertEquals(row * 2, percolation.numberOfOpenSites());
        }

        percolation.open(200, 1);
        percolation.open(200, 200);
        assertTrue(percolation.percolates());
    }

    @Test
    public void test2x2Init(){
        Percolation percolation = new Percolation(2);
        assertFalse(percolation.percolates());
        assertEquals(0, percolation.numberOfOpenSites());

        assertFalse(percolation.isFull(1, 1));
        assertFalse(percolation.isFull(1, 2));
        assertFalse(percolation.isFull(2, 1));
        assertFalse(percolation.isFull(2, 2));

        assertFalse(percolation.isOpen(1, 1));
        assertFalse(percolation.isOpen(1, 2));
        assertFalse(percolation.isOpen(2, 1));
        assertFalse(percolation.isOpen(2, 2));
    }

    @Test
    public void test1x1(){
        Percolation percolation = new Percolation(1);
        assertFalse(percolation.percolates());
    }

    @Test
    public void testOpenSite(){
        Percolation percolation = new Percolation(2);
        assertFalse(percolation.percolates());
        assertEquals(0, percolation.numberOfOpenSites());

        percolation.open(1,1);
        assertTrue(percolation.isOpen(1, 1));
        assertEquals(1, percolation.numberOfOpenSites());

        percolation.open(1,2);
        assertTrue(percolation.isOpen(1, 2));
        assertEquals(2, percolation.numberOfOpenSites());

        percolation.open(2,1);
        assertTrue(percolation.isOpen(2, 1));
        assertEquals(3, percolation.numberOfOpenSites());
    }

    @Test
    public void testPercolates(){
        Percolation percolation = new Percolation(2);
        assertFalse(percolation.percolates());

        percolation.open(1, 1);
        assertFalse(percolation.percolates());

        percolation.open(1, 2);
        assertFalse(percolation.percolates());

        percolation.open(2, 1);
        assertTrue(percolation.percolates());

        percolation.open(2, 2);
        assertTrue(percolation.percolates());
    }

    @Test
    public void testVerticalPercolates(){
        Percolation percolation = new Percolation(4);
        assertFalse(percolation.percolates());

        percolation.open(1, 2);
        assertFalse(percolation.percolates());

        percolation.open(2, 2);
        assertFalse(percolation.percolates());

        percolation.open(3, 2);
        assertFalse(percolation.percolates());

        percolation.open(4, 2);
        assertTrue(percolation.percolates());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgument() {
        new Percolation(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentNegative() {
        new Percolation(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void openIllegalArguments() {
        new Percolation(2).open(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void openIllegalArguments2() {
        new Percolation(2).open(-10, -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void openIllegalArguments3() {
        new Percolation(2).open(3, 3);
    }
}
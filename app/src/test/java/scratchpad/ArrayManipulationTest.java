package scratchpad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArrayManipulationTest {

    private static ArrayManipulation arrayManipulation;

    @BeforeAll
    public static void setUp() {
        arrayManipulation = new ArrayManipulation();
    }

    @Test
    public void chunkTest() {
        final int[][] result = arrayManipulation.chunk(new int[]{1, 2, 3, 4, 5}, 3);
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5}}, result);
    }

    @Test
    public void countOccurrencesTest() {
        final long result = arrayManipulation.countOccurrences(new int[]{1, 2, 3, 5, 5, 5}, 5);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void concatTest() {
        final Integer[] result = arrayManipulation.concat(new Integer[]{1, 2, 3, 5, 5, 5}, new Integer[]{1, 2, 3, 5, 5, 5});
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 5, 5, 5, 1, 2, 3, 5, 5, 5}, result);
    }

    @Test
    public void differenceTest() {
        final int[] arrayA = new int[]{1, 2, 3, 4, 7};
        final int[] arrayB = new int[]{2, 3, 4, 5, 6};
        final int[] result = arrayManipulation.difference(arrayA, arrayB);
        Assertions.assertArrayEquals(new int[]{1, 7}, result);
    }
}

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

    @Test
    public void differenceWithTestComparatorIsTrue() {
        final int[] result = arrayManipulation.differenceWith(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}, (arrayAItem, arrayBItem) ->
                arrayAItem == arrayBItem ? 0 : 1);
        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void deepFlatTest() {
        final int[] result = arrayManipulation.deepFlat(new Object[]{new Integer[]{1, 2, 3, 4}, 0, 1, 2, new Object[]{new Integer[]{4, 5, 6, 8}, 10, 11}});
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 0, 1, 2, 4, 5, 6, 8, 10, 11}, result);
    }

    @Test
    public void distinctValuesOfArrayTest() {
        final int[] result = arrayManipulation.distinctValuesOfArray(new int[]{1, 1, 2, 3, 3, 4});
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, result);

    }


    @Test
    public void dropElementsTest() {
        final int[] result = arrayManipulation.dropElements(new int[]{1, 1, 2, 3, 3, 4}, e -> e > 2);
        Assertions.assertArrayEquals(new int[]{3, 3, 4}, result);
    }


    @Test
    public void dropLeftElementsTest() {
        final int[] result = arrayManipulation.dropRight(new int[]{1, 1, 2, 3, 3, 4}, 3);
        Assertions.assertArrayEquals(new int[]{1, 1, 2}, result);
    }


    @Test
    public void everyNth() {
        final int[] result = arrayManipulation.everyNth(new int[]{1, 1, 2, 3, 3, 4}, 3);
        Assertions.assertArrayEquals(new int[]{2, 4}, result);
    }


    @Test
    public void indexOf() {
        final int result = arrayManipulation.indexOf(new int[]{1, 1, 2, 3, 3, 4}, 3);
        Assertions.assertEquals(3, result);

    }

    @Test
    public void lastIndexOf() {
        final int result = arrayManipulation.lastIndexOf(new int[]{1, 1, 2, 3, 3, 4}, 3);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void initialTest() {
        final Integer[] result = arrayManipulation.initial(new Integer[]{1, 1, 2, 3, 3, 4});
        Assertions.assertArrayEquals(new Integer[]{1, 1, 2, 3, 3}, result);
    }

    @Test
    public void filterNonUnique() {
        final int[] result = arrayManipulation.filterNonUnique(new int[]{1, 1, 2, 3, 3, 4});
        Assertions.assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    public void flattenTest() {
        final int[] result = arrayManipulation.flatten(new Object[]{
                new int[]{1, 2, 3},
                0, 1, 2, 3,
                new int[]{5, 25, 6, 36}
        });
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 0, 1, 2, 3, 5, 25, 6, 36}, result);
    }

}
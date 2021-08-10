package scratchpad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    @Test
    public void intArrayFlattenTest() {
        final int[] result = arrayManipulation.intArrayFlatten(new int[][]{
                new int[]{1, 2, 3}, new int[]{5, 25, 6, 36}
        });
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 5, 25, 6, 36}, result);
    }

    @Test
    public void flattenDepthTestDepth2() {
        final Object[] result = arrayManipulation.flattenDepth(new Object[]{
                0, 1,
                new Object[]{
                        new Object[]{new Object[]{1, 2, 4, 8}, 1, 1, 2, 3, 5, 8},
                        2, 3
                },
                new Object[]{5, 25, 6, 36},
                37, 38
        }, 2);
        Assertions.assertArrayEquals(new Object[]{0, 1, new Object[]{1, 2, 4, 8}, 1, 1, 2, 3, 5, 8, 2, 3, 5, 25, 6, 36, 37, 38}, result);
    }

    @Test
    public void flattenDepthTestDepth3() {
        final Object[] result = arrayManipulation.flattenDepth(new Object[]{
                0, 1,
                new Object[]{
                        new Object[]{new Object[]{1, 2, 4, 8}, 1, 1, 2, 3, 5, 8},
                        2, 3
                },
                new Object[]{5, 25, 6, 36},
                37, 38
        }, 3);
        Assertions.assertArrayEquals(new Object[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 3, 5, 8, 2, 3, 5, 25, 6, 36, 37, 38}, result);
    }

    @Test
    public void flattenDepthTestDepth4() {
        final Object[] result = arrayManipulation.flattenDepth(new Object[]{
                0, 1,
                new Object[]{
                        new Object[]{new Object[]{1, 2, 4, 8}, 1, 1, 2, 3, 5, 8},
                        2, 3
                },
                new Object[]{5, 25, 6, 36},
                37, 38
        }, 4);
        Assertions.assertArrayEquals(new Object[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 3, 5, 8, 2, 3, 5, 25, 6, 36, 37, 38}, result);
    }

    @Test
    public void groupBy() {
        final Map<Integer, List<Integer>> result = arrayManipulation.groupBy(new Integer[]{1, 2, 2, 3, 3, 5}, e -> e);
        Map<Integer, List<Integer>> map = getSampleDataForGroupBy();
        Assertions.assertEquals(map, result);
    }

    private Map<Integer, List<Integer>> getSampleDataForGroupBy() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        map.put(1, list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(2);
        map.put(2, list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(3);
        map.put(3, list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(5);
        map.put(5, list4);
        return map;
    }

    @Test
    public void initializeArrayWithRange() {
        final int[] result = arrayManipulation.initializeArrayWithRange(0, 5);
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, result);
    }

    @Test
    public void initializeArrayWithValues() {
        final int[] result = arrayManipulation.initializeArrayWithValues(5, 0);
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0}, result);
    }

    @Test
    public void intersection() {
        final int[] result = arrayManipulation.intersection(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6});
        Assertions.assertArrayEquals(new int[]{3, 4}, result);
    }


    @Test
    public void nthElement() {
        final int result = arrayManipulation.nthElement(new Integer[]{1, 2, 3, 4}, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void nthElementOutOfBounce() {
        final int result = arrayManipulation.nthElement(new Integer[]{1, 2, 3, 4}, 10);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void nthElementNegativeIndex() {
        final int result = arrayManipulation.nthElement(new Integer[]{1, 2, 3, 4}, -1);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void nthElementNegativeOutOfBounce() {
        final int result = arrayManipulation.nthElement(new Integer[]{1, 2, 3, 4}, -10);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void join() {
        final String result = arrayManipulation.join(new Integer[]{1, 2, 3, 4}, "", "");
        Assertions.assertEquals("1234", result);
    }

    @Test
    public void joinWithSeparator() {
        final String result = arrayManipulation.join(new Integer[]{1, 2, 3, 4}, "-", "");
        Assertions.assertEquals("1-2-3-4", result);
    }

    @Test
    public void joinWithSeparatorAndEnd() {
        final String result = arrayManipulation.join(new Integer[]{1, 2, 3, 4}, "-", ":");
        Assertions.assertEquals("1-2-3-4:", result);
    }

    @Test
    public void isSorted() {
        final int result = arrayManipulation.isSorted(new Integer[]{1, 2, 3, 4});
        Assertions.assertEquals(1, result);
    }

    @Test
    public void isSortedDescending() {
        final int result = arrayManipulation.isSorted(new Integer[]{3, 2, 1, 0, -1});
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void isSortedNotSorted() {
        final int result = arrayManipulation.isSorted(new Integer[]{1, 0, 3, 4});
        Assertions.assertEquals(0, result);
    }

    @Test
    public void pick() {
        final Map<Integer, Integer[]> result = arrayManipulation.pick(getSampleDataForPick(), new Integer[]{2, 3, 4});
        Assertions.assertTrue(areEqualWithArrayValue(getExpectedDataForPick(), result));
    }

    public boolean areEqualWithArrayValue(Map<Integer, Integer[]> first, Map<Integer, Integer[]> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> Arrays.equals(e.getValue(), second.get(e.getKey())));
    }

    private Map<Integer, Integer[]> getExpectedDataForPick() {
        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(2, new Integer[]{2, 3, 4, 5});
        map.put(3, new Integer[]{3, 4, 5, 6});
        map.put(4, new Integer[]{4, 5, 6, 7});
        return map;
    }

    private Map<Integer, Integer[]> getSampleDataForPick() {
        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(1, new Integer[]{1, 2, 3, 4});
        map.put(2, new Integer[]{2, 3, 4, 5});
        map.put(3, new Integer[]{3, 4, 5, 6});
        map.put(4, new Integer[]{4, 5, 6, 7});
        map.put(5, new Integer[]{5, 6, 7, 8});
        return map;
    }

    @Test
    public void sample() {
        final Integer[] array = {1, 2, 3, 4, 5};
        final int result = arrayManipulation.sample(array);
        Assertions.assertTrue(Arrays.stream(array).collect(Collectors.toSet()).contains(result));
    }

    @Test
    public void tail() {
        final Integer[] result = arrayManipulation.tail(new Integer[]{1, 2, 4, 5});
        Assertions.assertArrayEquals(new Integer[]{2, 4, 5}, result);
    }


    @Test
    public void tailTestArrayEmpty() {
        final Integer[] result = arrayManipulation.tail(new Integer[]{});
        Assertions.assertArrayEquals(new Integer[]{}, result);
    }

    @Test
    public void tailTestArrayWithOneElement() {
        final Integer[] result = arrayManipulation.tail(new Integer[]{2});
        Assertions.assertArrayEquals(new Integer[]{2}, result);
    }

    @Test
    public void take() {
        final Integer[] result = arrayManipulation.take(new Integer[]{1, 2, 3, 4, 5}, 2);
        Assertions.assertArrayEquals(new Integer[]{1, 2}, result);
    }

    @Test
    public void takeRight() {
        final Integer[] result = arrayManipulation.takeRight(new Integer[]{1, 2, 3, 4, 5}, 2);
        Assertions.assertArrayEquals(new Integer[]{4, 5}, result);
    }

    @Test
    public void union() {
        final Integer[] result = arrayManipulation.union(new Integer[]{1, 2, 3, 4}, new Integer[]{3, 4, 5, 6});
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, result);
    }

    @Test
    public void similarity() {
        final Integer[] result = arrayManipulation.similarity(new Integer[]{1, 2, 3, 4}, new Integer[]{3, 4, 5, 6});
        Assertions.assertArrayEquals(new Integer[]{3, 4}, result);
    }
}
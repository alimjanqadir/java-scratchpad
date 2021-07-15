package scratchpad;

import java.util.Arrays;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayManipulation {

    public int[][] chunk(int[] array, int size) {
        return IntStream.iterate(0, i -> i + size)
                .limit((long) Math.ceil((double) array.length / size))
                .mapToObj(cur -> Arrays.copyOfRange(array, cur, Math.min(cur + size, array.length)))
                .toArray(int[][]::new);
    }

    public long countOccurrences(int[] numbers, int value) {
        return Arrays
                .stream(numbers)
                .filter(number -> number == value)
                .count();
    }

    public <T> T[] concat(T[] arrayA, T[] arrayB) {
        return Stream.concat(
                Stream.of(arrayA),
                Stream.of(arrayB)
        ).toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, arrayA.getClass()));
    }

    /**
     * @return An array with the elements that is not in arrayB.
     */
    public int[] difference(int[] arrayA, int[] arrayB) {
        Set<Integer> set = Arrays.stream(arrayB).boxed().collect(Collectors.toSet());
        return Arrays.stream(arrayA)
                .filter(e -> !set.contains(e))
                .toArray();
    }

    public int[] differenceWith(int[] arrayA, int[] arrayB, IntBinaryOperator comparator) {
        return Arrays.stream(arrayA)
                .filter(elementFromArrayA ->
                        Arrays.stream(arrayB)
                                .noneMatch(elementFromArrayB ->
                                        comparator.applyAsInt(elementFromArrayA, elementFromArrayB) == 0))
                .toArray();
    }

    public int[] deepFlat(Object[] array) {
        return Arrays.stream(array)
                .flatMapToInt(o -> {
                    if (o instanceof Object[]) {
                        return Arrays.stream(deepFlat((Object[]) o));
                    }
                    return IntStream.of((Integer) o);
                }).toArray();
    }

    public int[] distinctValuesOfArray(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }
}

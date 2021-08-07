package scratchpad;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
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

    public int[] dropElements(int[] array, IntPredicate predicate) {
        while (array.length > 0 && !predicate.test(array[0])) {
            array = Arrays.copyOfRange(array, 1, array.length);
        }
        return array;
    }

    public int[] dropRight(int[] array, int dropElementCount) {
        if (dropElementCount < 0) {
            throw new IllegalArgumentException("drop element count can't be lower than 0");
        }
        return dropElementCount < array.length ?
                Arrays.copyOfRange(array, 0, array.length - dropElementCount)
                : new int[0];
    }

    public int[] everyNth(int[] array, int nth) {
        return IntStream.range(0, array.length)
                .filter(i -> i % nth == nth - 1)
                .map(i -> array[i])
                .toArray();
    }

    public int indexOf(int[] array, int element) {
        return IntStream.range(0, array.length)
                .filter(e -> array[e] == element)
                .findFirst()
                .orElse(-1);
    }

    public int lastIndexOf(int[] array, int element) {
        return IntStream.iterate(array.length - 1, i -> i - 1)
                .limit(array.length)
                .filter(e -> element == array[e])
                .findFirst()
                .orElse(-1);
    }

    /**
     * @param array input array
     * @return elements without the last element.
     */
    public <T> T[] initial(T[] array) {
        return Arrays.copyOfRange(array, 0, array.length - 1);
    }

    public int[] filterNonUnique(int[] array) {
        return Arrays.stream(array)
                .filter(e -> indexOf(array, e) == lastIndexOf(array, e))
                .toArray();
    }

    public int[] flatten(Object[] array) {
        return Arrays.stream(array)
                .flatMapToInt(element -> element instanceof int[]
                        ? Arrays.stream((int[]) element)
                        : IntStream.of((Integer) element))
                .toArray();
    }

    public int[] intArrayFlatten(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(IntStream::of)
                .toArray();
    }

    public Object[] flattenDepth(Object[] array, int depth) {
        if (depth == 0) {
            return array;
        }
        return Arrays.stream(array)
                .flatMap(e -> e instanceof Object[]
                        ? Arrays.stream(flattenDepth((Object[]) e, depth - 1))
                        : Arrays.stream(new Object[]{e})
                ).toArray();
    }

    public <T, R> Map<R, List<T>> groupBy(T[] array, Function<T, R> function) {
        return Arrays.stream(array).collect(Collectors.groupingBy(function));
    }

    public int[] initializeArrayWithRange(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }

    public int[] initializeArrayWithValues(int size, int value) {
        return IntStream.generate(() -> value)
                .limit(size)
                .toArray();
    }

    public int[] intersection(int[] arrayA, int[] arrayB) {
        final Set<Integer> setFromArrayB = Arrays.stream(arrayB).boxed().collect(Collectors.toSet());
        return Arrays.stream(arrayA)
                .filter(setFromArrayB::contains)
                .toArray();
    }

    public <T> int nthElement(T[] array, int n) {
        if (Math.abs(n) > array.length) return -1;

        if (n > 0) {
            return (int) Arrays.copyOfRange(array, n, array.length)[0];
        }
        return (int) Arrays.copyOfRange(array, array.length + n, array.length)[0];
    }

    public <T> String join(T[] array, String separator, String end) {
        return IntStream.range(0, array.length)
                .mapToObj((i) -> new AbstractMap.SimpleEntry<>(i, array[i]))
                .reduce("", (acc, val) -> val.getKey() == array.length - 1
                                ? acc + val.getValue() + end
                                : acc + val.getValue() + separator,
                        (a, b) -> a);
    }

    public <T extends Comparable<T>> int isSorted(T[] array) {
        final int direction = array[0].compareTo(array[1]) < 0 ? 1 : -1;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                return direction;
            } else if (array[i].compareTo(array[i + 1]) * direction > 0) return 0;
        }
        return direction;
    }

    public <T, R> Map<T, R[]> pick(Map<T, R[]> object, T[] array) {
        return Arrays.stream(array)
                .filter(object::containsKey)
                .collect(Collectors.toMap(k -> k, object::get));
    }

    public <T> T sample(T[] array) {
        return array[(int) Math.floor(Math.random() * array.length)];
    }

    public <T> T[] tail(T[] array) {
        return array.length > 1
                ? Arrays.copyOfRange(array, 1, array.length)
                : array;
    }

    public <T> T[] take(T[] array, int n) {
        return Arrays.copyOfRange(array, 0, n);
    }
}

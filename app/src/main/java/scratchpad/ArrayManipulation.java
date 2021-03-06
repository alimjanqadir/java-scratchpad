package scratchpad;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.*;
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

    public <T> T[] takeRight(T[] array, int n) {
        return Arrays.copyOfRange(array, array.length - n, array.length);
    }

    public <T> T[] union(T[] arrayA, T[] arrayB) {
        Set<T> set = new HashSet<>(Arrays.asList(arrayA));
        set.addAll(Arrays.asList(arrayB));
        return set.toArray((T[]) Arrays.copyOf(new Object[0], 0, arrayA.getClass()));
    }

    public <T> T[] similarity(T[] arrayA, T[] arrayB) {
        return Arrays.stream(arrayA).
                filter(elementFromArrayA -> Arrays.asList(arrayB).contains(elementFromArrayA))
                .toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, arrayA.getClass()));
    }

    public <T> T[] without(T[] array, T... excludedElements) {
        return Arrays.stream(array).
                filter(e -> !Arrays.asList(excludedElements).contains(e))
                .toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, array.getClass()));
    }

    public <T> T[] symmetricDifference(T[] arrayA, T[] arrayB) {
        Set<T> a = new HashSet<>(Arrays.asList(arrayA));
        Set<T> b = new HashSet<>(Arrays.asList(arrayB));
        return Stream.concat(
                Arrays.stream(arrayA).filter(e -> !b.contains(e)),
                Arrays.stream(arrayB).filter(e -> !a.contains(e))
        ).toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, arrayA.getClass()));
    }

    public Map<String, Object>[] reducedFilter(Map<String, Object>[] data, String[] keys, Predicate<Map<String, Object>> predicate) {
        return Arrays.stream(data)
                .filter(predicate)
                .map(item -> Arrays.stream(keys).filter(item::containsKey)
                        .collect(Collectors.toMap(Function.identity(), item::get))
                ).toArray((IntFunction<Map<String, Object>[]>) Map[]::new);
    }

    public <T extends Comparable<T>> int sortedIndex(T[] array, T element) {
        boolean descending = array[0].compareTo(array[array.length - 1]) > 0;
        return IntStream.range(0, array.length)
                .filter(i -> descending ? element.compareTo(array[i]) >= 0 : element.compareTo(array[i]) <= 0)
                .findFirst()
                .orElse(array.length);
    }

    public <T> T[] sampleSize(T[] array, int n) {
        var copiedArray = Arrays.copyOf(array, array.length);
        var length = array.length;
        var m = length;
        while (m > 0) {
            var i = (int) Math.floor(Math.random() * m--);
            var temp = copiedArray[i];
            copiedArray[i] = copiedArray[m];
            copiedArray[m] = temp;
        }
        return Arrays.copyOf(copiedArray, Math.min(n, length));
    }

    public <T> T[] shuffle(T[] array) {
        var copiedArray = Arrays.copyOf(array, array.length);
        var m = copiedArray.length;
        while (m > 0) {
            var i = (int) Math.floor(Math.random() * m--);
            var temp = copiedArray[i];
            copiedArray[i] = copiedArray[m];
            copiedArray[m] = temp;
        }
        return copiedArray;
    }

    public List<Object[]> zip(Object[]... array) {
        var max = Arrays.stream(array).mapToInt(nestedArray -> nestedArray.length).max();
        return IntStream.range(0, max.orElseThrow())
                .mapToObj(
                        i -> Arrays.stream(array)
                                .map(nestedArray -> i < nestedArray.length ? nestedArray[i] : null)
                                .toArray()
                ).collect(Collectors.toList());
    }

    public Map<String, Object> zipObject(String[] properties, Object[] values) {
        return IntStream.range(0, properties.length)
                .mapToObj(i -> new SimpleEntry<>(properties[i], values[i]))
                .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), HashMap::putAll);
    }
}

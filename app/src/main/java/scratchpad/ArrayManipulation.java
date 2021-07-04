package scratchpad;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayManipulation {
    public static void main(String[] args) {
        // Splitting the array
        IntStream.iterate(0, i -> i + 5).limit(10).forEach(System.out::println);
    }

    public int[][] chunk(int[] array, int size) {
        return IntStream.iterate(0, i -> i + size)
                .limit((long) Math.ceil((double) array.length / size))
                .mapToObj(cur -> Arrays.copyOfRange(array, cur, Math.min(cur + size, array.length)))
                .toArray(int[][]::new);
    }
}

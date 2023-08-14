package scratchpad.algo;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        d %= a.size();
        int length = a.size();
        reverse(a, 0, length - 1);
        reverse(a, 0, length - 1 - d);
        reverse(a, length - d , length - 1);

        return a;
    }

    public static void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start += 1;
            end -= 1;
        }
    }
}

public class LeftRotate {
    public static void main(String[] args) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int d = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.rotLeft(a, d);
            System.out.println(result);
            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

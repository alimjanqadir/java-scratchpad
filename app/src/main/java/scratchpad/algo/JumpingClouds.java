package scratchpad.algo;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class JumpingClouds {
    static class Result {

        /*
         * Complete the 'jumpingOnClouds' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY c as parameter.
         */

        public static int jumpingOnClouds(List<Integer> c) {
            // Write your code here
            int counter = -1;
            int length = c.size();
            for (int i = 0; i < length; ) {
                if (i + 2 < length && c.get(i + 2) == 0) {
                    i = i + 2;
                } else {
                    i += 1;
                }
                counter += 1;
            }
            return counter;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/alimjan/.temp/temp"))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.jumpingOnClouds(c);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

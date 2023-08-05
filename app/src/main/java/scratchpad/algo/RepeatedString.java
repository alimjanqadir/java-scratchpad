package scratchpad.algo;

import java.io.*;

import static java.util.stream.Collectors.joining;

public class RepeatedString {
    static class Result {

        /*
         * Complete the 'repeatedString' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. LONG_INTEGER n
         */

        public static long repeatedString(String s, long n) {
            // Write your code here
            int strLength = s.length();
            long q = 0, r = 0;
            q = n / strLength;
            r = n % strLength;
            long aCount = q * getLetterCount(s, s.length()) + getLetterCount(s, r);
            return aCount;
        }

        static long getLetterCount(String s, long strLength) {
            long count = 0;
            for (int i = 0; i < strLength; i++) {
                if (s.charAt(i) == 'a')
                    count += 1;
            }
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                System.getenv("OUTPUT_PATH")
        ));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

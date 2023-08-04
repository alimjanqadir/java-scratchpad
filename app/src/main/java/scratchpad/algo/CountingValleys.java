package scratchpad.algo;

import java.io.*;


public class CountingValleys {
    private static class Result {

        /*
         * Complete the 'countingValleys' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER steps
         *  2. STRING path
         */

        public static int countingValleys(int steps, String path) {
            // Write your code here
            int altitude = 0, valleyCount = 0;
            for (int i = 0; i < steps; i += 1) {
                if (path.charAt(i) == 'U') {
                    altitude += 1;

                    if (altitude == 0) {
                        valleyCount += 1;
                    }
                } else {
                    altitude -= 1;
                }
            }
            return valleyCount;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                     System.getenv("OUTPUT_PATH")
             ))) {


            int steps = Integer.parseInt(bufferedReader.readLine().trim());

            String path = bufferedReader.readLine();

            int result = Result.countingValleys(steps, path);

            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

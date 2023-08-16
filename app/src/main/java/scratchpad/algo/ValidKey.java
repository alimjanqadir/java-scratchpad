package scratchpad.algo;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static java.util.stream.Collectors.joining;


public class ValidKey {
    private static class Result {
        public static int[] getValidKeyCount(int[] keys) {
            int n = keys[keys.length - 1];
            int[] dp = new int[n + 1];
            dp[0] = 0;

            for (int i = 1; i <= n; i++) {
                if (isValidKey(i)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }

            int[] result = new int[keys.length];
            for (int i = 0; i < keys.length; i++) {
                result[i] = query(dp, 1, keys[i]);
            }

            return result;
        }

        public static boolean isValidKey(int key) {
            int divisorCount = 0;
            for (int i = 1; i <= Math.sqrt(key); i++) {
                if (key % i == 0) {
                    if (key / i == i) {
                        divisorCount++;
                    } else {
                        divisorCount += 2;
                    }
                }
                if (divisorCount > 3) return false;
            }
            return divisorCount == 3;
        }

        public static int query(int[] dp, int l, int r) {
            return dp[r] - dp[l - 1];
        }


        public static int[] getValidKeyCount2(int[] keys) {
            int[] result = new int[keys.length];
            for (int i = 0; i < keys.length; i += 1) {
                result[i] = countPrimeSquares(keys[i]);
            }
            return result;
        }


        public static int[] getValidKeyCount3(int[] keys) {
            int[] result = new int[keys.length];
            for (int i = 0; i < keys.length; i += 1) {
                result[i] = sieveOfEratosthenesImproved(keys[i]).size();
            }
            return result;
        }


        public static int countPrimeSquares(int n) {
            int count = 0;
            List<Integer> primes = sieveOfEratosthenes(n);
            for (Integer prime : primes) {
                int square = prime * prime;
                if (square <= n) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

        public static List<Integer> sieveOfEratosthenes(int n) {
            boolean[] isPrime = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                isPrime[i] = true;
            }
            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i)
                        isPrime[j] = false;
                }

            }
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (isPrime[i])
                    primes.add(i);
            }
            return primes;
        }

        public static List<Integer> sieveOfEratosthenesImproved(int n) {
            int size = (int) Math.ceil(Math.sqrt(n));
            boolean[] isPrime = new boolean[size];

            for (int i = 2; i < size; i++) {
                isPrime[i] = true;
            }

            int limit = (int) Math.sqrt(size);
            for (int i = 2; i <= limit; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < size; j += i)
                        isPrime[j] = false;
                }
            }

            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i < size; i++) {
                if (isPrime[i])
                    primes.add(i);
            }
            return primes;
        }
    }


    // Sieve of Eratosthenes algorithm
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
//            int keysCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            int[] keys = IntStream.range(0, keysCount).mapToObj(i -> {
//                try {
//                    return bufferedReader.readLine().replaceAll("\\s+$", "");
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }).map(String::trim).mapToInt(Integer::parseInt).toArray();
            Instant start = Instant.now();
            int[] result = Result.getValidKeyCount2(new int[]{10000000});
            Instant end = Instant.now();
            System.out.printf("Elapsed Time: %d%n", Duration.between(start, end).toMillis());

            System.out.println(Arrays.toString(result));
            bufferedWriter.write(Arrays.stream(result).mapToObj(String::valueOf).collect(joining("\n")) + "\n");
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}

package scratchpad.algo;




class IsValidKey {
    public static int countValidKey(int n) {
        int validKeyCounter = 0;
        for (int i = 1; i <= n; i++) {
            if (isValidKey(i)) {
                validKeyCounter += 1;
            }
        }

        return validKeyCounter;
    }

//    public static boolean isValidKey(int key) {
//        int divisorCount = countDivisors(key);
//        return divisorCount == 3;
//    }

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


    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countValidKey(10000000));
    }
}
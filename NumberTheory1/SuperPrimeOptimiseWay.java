import java.io.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int superPrimeCount = 0;

        boolean[] isPrime = new boolean[N + 1];
        int[] primeCount = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primeCount[i]++;

                for (int j = 2 * i; j <= N; j += i) {
                    isPrime[j] = false;
                    primeCount[j]++;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (primeCount[i] == 2) {
                superPrimeCount++;
            }
        }

        System.out.println(superPrimeCount);
    }
}

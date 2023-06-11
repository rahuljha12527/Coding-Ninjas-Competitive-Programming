// Segmented Sieve Problem
// Send Feedback
// In this problem you have to print all primes from given interval.
// Input Format:
// First line of input will contain T(number of test cases), each test case follows as.

// On each line are written two integers L and U separated by a blank. L - lower bound of 
// interval, U - upper bound of interval.
// Output Format:
// For each test case output must contain all primes from interval [L; U] in increasing order.
// Constraints:
// 1  <= T <= 100
// 1 <= L <= U <= 10^9
// 0 <= U - L <= 10^5
// Sample Input:
// 2
// 2 10
// 3 7
// Sample Output:
// 2 3 5 7
// 3 5 7 

import java.util.*;

public class Solution {

    public static List<Integer> sieve(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] ar = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            ar[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (ar[i] == true) {
                for (int j = i * i; j <= n; j += i)
                    ar[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (ar[i] == true) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int t;
        int L, R;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        while (t-- > 0) {
            L = sc.nextInt();
            R = sc.nextInt();

            if (L == 1) {
                L++;
            }

            int limit = (int) Math.sqrt(R);
            List<Integer> primes = sieve(limit);
		
            boolean[] isPrime = new boolean[R - L + 1];

            for (int i = 0; i <= R - L; i++) {
                isPrime[i] = true;
            }

            for (int p : primes) {
                int s = (L / p) * p;
                if (s < L )
                    s += p;
				if(L==2) {
					s+=p;
				}

                for (int j = s; j <= R; j += p)
                    isPrime[j - L] = false;
            }

            for (int i = L; i <= R; i++) {
                if (isPrime[i - L] == true) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}

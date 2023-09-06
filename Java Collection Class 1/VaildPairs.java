// Valid pairs
// Send Feedback
// Given an array of integers and numbers k and m, write a function that returns true if given array can be divided into pairs such that the sum of every pair gives remainder m when divided by k.
// Input format :
// Line 1 : Integer N 
// Line 2 : N integers separated be a single space
// Line 3 : Integer K
// Line 4 : Integer M
// Output Format :
//  Boolean
// Constraints :
//  1 <= N <= 10^4
//  1 <= M < K <= 10^2
// Sample Input :
// 4
// 2 1 5 7
// 9
// 3
// Sample Output :
// true
// Explanation :
// Pairs will be (2,1) and (5,7)

public class solution {

  public static boolean CheckSumPairs(int[] arr, int n, int k, int m) {
    if (n % 2 == 1) {
      return false;
    }

    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i] == false && visited[j] == false) {
          if ((arr[i] + arr[j]) % k == m) {
            visited[i] = true;
            visited[j] = true;
            break;
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (visited[i] == false) {
        return false;
      }
    }

    return true;
  }
}

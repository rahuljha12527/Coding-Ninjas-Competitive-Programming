// Super Prime
// Send Feedback
// A number is called super-prime if it has exactly two distinct prime divisors
// Example 10 , 6
// You are supposed to find the count of super-prime numbers between 1 and N (inclusive).
// Input Format:
// Contain an integer N
// Output Format:
// Print the number of super prime between [1, N]
// Constraints:
// 1 <= N <= 10^6
// Sample Input 1:
// 10
// Sample Output 1:
// 2
// Sample Input 2:
// 25
// Sample Output 2:
// 10
// Explanation:
// The super-primes are: 6, 10, 12, 14, 15, 18, 20, 21, 22, 24.


import java.io.*;

public class Solution{

    public static boolean isPrime(int n){

        if(n<1){
            return false;

        }

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        // Your class should be named Solution
        // Write your code here

    


     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

     int N=Integer.parseInt(br.readLine());
     int count=0;

      for(int num=1;num<=N;num++){
            int divisior=0;

            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    if(isPrime(i)){
                        divisior++;
                    }

                    if(num/i!=i && isPrime(num/i)){
                        divisior++;
                    }
                }
            }
            if(divisior==2){
                count++;
            }
      }

      System.out.println(count);


     

    }
}
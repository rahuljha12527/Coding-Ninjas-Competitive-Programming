// GCD
// Send Feedback
// Calculate and return GCD of two given numbers x and y. Numbers are within range of Integer.
// Input format :
// First line of Input will contain T(number of test cases), each test case follows as.
// x and y (separated by space)
// Output format :
// Print GCD of x and y for each test case in newline
// Constraints:
// 1 <= T <= 10^5
// 1 <= x, y <= 10^9
// Sample Input 1:
// 1
// 20 5
// Sample Output 1:
// 5
// Sample Input 2:
// 1
// 96 14
// Sample Output 2:
// 2
import java.io.*;
import java.util.*;
public class Solution{

   public static int gcd(int a,int b){
       if(b==0){
           return a;
       }

       return gcd(b,a%b);
   }
    public static void main(String[] args) throws NumberFormatException, IOException {

        int t,a,b;

        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();

        while(t-->0){
            a=sc.nextInt();
            b=sc.nextInt();

            System.out.println(gcd(a,b));
        }

    }
}
//Minimum Absolute Difference in Array


// Given an integer array A of size N, find and return the minimum absolute difference between any two elements in the array.
// We define the absolute difference between two elements ai and aj (where i != j ) as |ai - aj|.
// Input format :
// The first line of input contains an integer that denotes the number of test cases. Let us denote it by the symbol T. 
// Each of the test cases contain two lines. The first line of each test case contains an integer, that denotes the value of N. The following line contains N space separated integers, that denote the array elements.
// Constraints :
// 1 <= T <= 10
// 2 <= N <= 10^5
// 0 <= arr[i] <= 10^8
// Output Format :
// You have to print minimum difference for each test case in new line.
// Sample Input 1:
// 1
// 5
// 2 9 0 4 5
// Sample Output 1:
// 1




import java.util.*;
import java.util.Scanner;
public class Solution {


	public static void main(String[] args) {
		/* 
			* Your class should be named Solution.
			* Read input as specified in the question.
			* Print output as specified in the question.
			* Write your code here
		 */

		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t!=0){
			 int n=sc.nextInt();
			 int []arr=new int[n];
			 for(int i=0;i<n;i++){
				 arr[i]=sc.nextInt();
			 }
              Arrays.sort(arr);
              int ans=Integer.MAX_VALUE;
			  for(int i=0;i<n-1;i++){
                  ans=Math.min(ans,arr[i+1]-arr[i]);
			  }

			  System.out.println(ans);
			
			 t--;
		 }

		 


		 

	}

}

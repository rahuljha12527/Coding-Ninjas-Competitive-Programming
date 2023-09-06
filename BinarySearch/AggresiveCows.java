// Aggressive Cows
// Send Feedback
// You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.


// You are also given an integer 'k' which denotes the number of aggressive cows.


// You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.


// Print the maximum possible minimum distance.


// Example:
// Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

// Output: 2

// Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
// Input format :
// The first line contains two integers ‘n’ and ‘k’ denoting the number of elements in the array and the number of aggressive cows.

// The second line contains ‘n’ single space-separated integers denoting the position of the stalls.


// Output format :
// Return the largest possible minimum distance between cows.


// Note :
// You do not need to print anything; it has already been handled.
// Sample Input 1 :
// 6 4
// 0 3 4 7 10 9


// Sample Output 1 :
// 3


// Explanation to Sample Input 1 :
// The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here distance between cows are 3, 4 and 3 respectively.


// Sample Input 2 :
// 5 2
// 4 2 1 3 6


// Sample Output 2 :
// 5


// Expected time complexity:
// Can you solve this in O(n * log(n)) time complexity?


// Constraints :
// 2 <= 'n' <= 10 ^ 5
// 2 <= 'k' <= n
// 0 <= 'arr[i]' <= 10 ^ 9
// Time Limit: 1 sec.


import java.util.Arrays;
public class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Sort the array of stalls in ascending order
        Arrays.sort(stalls);
        
        int n = stalls.length;
        int low = 0; // Minimum possible distance between cows
        int high = stalls[n - 1]; // Maximum possible distance between cows
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid-distance
            
            // Check if it is possible to place 'k' cows with minimum distance 'mid'
            if (isPossible(stalls, k, mid)) {
                result = mid; // Update the result to the current mid-distance
                low = mid + 1; // Search for larger distance
            } else {
                high = mid - 1; // Search for smaller distance
            }
        }
        
        return result;
    }
    
    // Helper function to check if it is possible to place 'k' cows with minimum distance 'dist'
    private static boolean isPossible(int[] stalls, int k, int dist) {
        int count = 1; // Count of cows placed
        int prevPos = stalls[0]; // Position of the previously placed cow
        
        for (int i = 1; i < stalls.length; i++) {
            int currPos = stalls[i]; // Position of the current stall
            
            // If the distance between the current stall and the previous placed cow is greater than or equal to 'dist'
            // We can place another cow at the current stall
            if (currPos - prevPos >= dist) {
                count++;
                prevPos = currPos; // Update the position of the previously placed cow
            }
            
            // If we have placed 'k' cows, return true
            if (count == k) {
                return true;
            }
        }
        
        return false; // If we cannot place 'k' cows with minimum distance 'dist'
    }
}

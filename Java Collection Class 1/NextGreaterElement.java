//Next Geater Element

// Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x, is the first greater element on right side of x in the array. Elements for which no greater element exist, consider next greater element as -1.
// Input format :

// Line 1 : Size of input array

// Line 2 : Array elements (separated by space)

// Constraints:
// Time Limit: 1 second
// Size of input array lies in the range: [1, 1000000]
// Sample Input
// 5
// 3  8  1  2  0
// Sample Output
// 8 -1  2 -1 -1
import java.util.*;
import java.util.ArrayList;
import java.util.Stack;

public class solution {

  // Function to find the Next Greater Element for each element in the input array
  public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> input) {
    int n = input.size();
    ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(n, 0));
    Stack<Integer> stack = new Stack<Integer>();

    // Traverse the input array from right to left
    for (int i = n - 1; i >= 0; i--) {
      if (stack.isEmpty()) {
        // If the stack is empty, there's no greater element to the right
        output.set(i, -1);
        stack.push(input.get(i));
      } else {
        // While the stack is not empty and the top element is smaller than the current element
        while (!stack.isEmpty() && stack.peek() <= input.get(i)) {
          stack.pop();
        }

        if (stack.isEmpty()) {
          // If the stack becomes empty, there's no greater element to the right
          output.set(i, -1);
          stack.push(input.get(i));
        } else {
          // If a greater element is found, set it as the output and push the current element to the stack
          output.set(i, stack.peek());
          stack.push(input.get(i));
        }
      }
    }

    return output;
  }
}

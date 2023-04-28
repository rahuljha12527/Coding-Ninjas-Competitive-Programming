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


import java.util.Stack;
import java.util.ArrayList;
import java.util.*;

public class solution {
	public static ArrayList<Integer> nextGreaterElement(ArrayList<Integer> input) {
		int n=input.size();
	ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(n, 0));
    Stack<Integer> stack=new Stack<Integer>();
	for(int i=n-1;i>=0;i--){
	//	System.out.println("aaaa",+i);
		if(stack.isEmpty()){
		    output.set(i,-1);

			stack.push(input.get(i));

		}
		else{
            while(!stack.isEmpty() && stack.peek()<=input.get(i)){
				stack.pop();
			}

			if(stack.isEmpty()){
				output.set(i,-1);
				stack.push(input.get(i));
			
			}
			else{
				output.set(i,stack.peek());
				stack.push(input.get(i));
			}


		}
	}

	return output;
        
	}
}
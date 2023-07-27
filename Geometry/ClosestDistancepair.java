// Day 4 : Closest Distance Pair
// You are given an array containing 'N' points in the plane. The task is to find out the distance of the closest points.
// Note :
// Where distance between two points (x1, y1) and (x2, y2) is calculated as [(x1 - x2) ^ 2] + [(y1 - y2) ^ 2].
// Input Format :
// The first line contains a single integer 'N' denoting the number of points.

// The next 'N' lines contain two integers separated by a single space, where the first integer represents the x coordinate and the second integer represents the y coordinate.
// Output Format :
// The only line contains the minimum distance between the 'N' points.
// Note:
// You do not need to print anything, it has already been taken care of. Just implement the given function.
// Constraints :
// 2 <= 'N' <= 10^5
// -10^5 <= 'x' <= 10^5 
// -10^5 <= 'y' <= 10^5

// Time Limit: 1 sec
// Sample Input 1:
// 5
// 1 2
// 2 3
// 3 4
// 5 6
// 2 1
// Sample Output 1:
// 2
// Explanation of Sample Output 1:
// We have 2 pairs which are probable answers (1, 2) with (2, 3) and (2, 3) with (3, 4). The distance between both of them is equal to 2.
// Sample Input 2 :
// 3
// 0 0
// -3 -4
// 6 4
// Sample Output 2 :
// 25
// Explanation of Sample Output 1 :
// If we choose the pairs (0, 0) and (-3, -4), the distance between them is 3^2 + 4^2 = 25. This is the optimal answer for this test case.

/*
    Time Complexity = O(N*logN*logN)
    Space Complexity = O(N*logN)

    Where N is the number of coordinates.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

	private static long dist(point p1, point p2) {
		// find distance between points p1 and p2
		long dis = (long) ((long) p1.x - p2.x) * (p1.x - p2.x) + (long) ((long) p1.y - p2.y) * (p1.y - p2.y);
		return dis;
	}

	private static long findMinDist(point pts[], int n) {

		// find minimum distance between two points in a set
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (dist(pts[i], pts[j]) < min) {
					min = dist(pts[i], pts[j]);
				}
			}
		}

		return min;
	}

	private static long stripClose(ArrayList<point> strip, long d) {

		// sort the strip array with respect to y coordinates.
		Collections.sort(strip, new Comparator<point>() {
			public int compare(point p1, point p2) {
				if (p1.y <= p2.y) {
					return -1;
				}
				return 1;
			}
		});

		// find closest distance of two points in a strip
		long min = d;
		for (int i = 0; i < strip.size(); ++i) {
			for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; ++j) {
				if (dist(strip.get(i), strip.get(j)) < min) {
					min = dist(strip.get(i), strip.get(j));
				}
			}
		}

		return min;
	}

	private static long findClosest(point xSorted[], int n) {

		if (n <= 3) {
			return findMinDist(xSorted, n);
		}

		int mid = n / 2;

		point midPoint = xSorted[mid];

		int leftIndex = 0, rightIndex = 0;

		// x sorted points in the left side
		point xSortedLeft[] = new point[mid + 1];

		// x sorted points in the right side
		point xSortedRight[] = new point[n - mid - 1];

		for (int i = 0; i < n; i++) {
			if (i < xSortedLeft.length) {
				xSortedLeft[leftIndex++] = xSorted[i];
			} else {
				xSortedRight[rightIndex++] = xSorted[i];
			}
		}

		// get minimum distance of left and right part.
		long leftDist = findClosest(xSortedLeft, mid + 1);
		long rightDist = findClosest(xSortedRight, n - mid - 1);

		long dist = Math.min(leftDist, rightDist);

		// hold points closer to the vertical line
		ArrayList<point> strip = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (Math.abs(xSorted[i].x - midPoint.x) < dist) {
				strip.add(xSorted[i]);
			}
		}

		// find minimum using distance and closest pair in strip
		return Math.min(dist, stripClose(strip, dist));
	}

	public static long closestPair(point coordinates[], int n) {

		// find distance of closest pair in a set of points
		point[] xSorted = new point[n];

		for (int i = 0; i < n; i++) {
			xSorted[i] = coordinates[i];
		}

		// sort coordinates with respect to x values.
		Arrays.sort(xSorted, new Comparator<point>() {
			public int compare(point p1, point p2) {
				if (p1.x <= p2.x) {
					return -1;
				}
				return 1;
			}
		});

		return findClosest(xSorted, n);
	}

}
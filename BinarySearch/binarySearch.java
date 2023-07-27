import java.util.*;

class CodingNinja {

  static int binarySearch(int arr[], int l, int r, int x) {
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == x) return mid; else if (arr[mid] > x) r =
        mid - 1; else l = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 5, 10, 11, 22 };
    int n = arr.length;
    int x = 12;
    int result = binarySearch(arr, 0, n - 1, x);
    if (result == -1) {
      System.out.println("Element not present");
    } else {
      System.out.println("Element is present on index " + result);
    }
  }
}

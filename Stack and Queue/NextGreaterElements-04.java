// Question Link:-
// http://geeksforgeeks.org/problems/next-larger-element-1587115620/1

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(N)
import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int nextGreater = -1;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nextGreater = arr[j];
                    break;
                }
            }
            ans.add(nextGreater);
        }
        return ans;
    }
}

/**
 * MONOTONIC STACK = IT MEANS THAT WE ARE STORING THE ELEMENTS IN A SPECIFIC
 * ORDER I.E. INCREASING ORDER OR DECREASING ORDER.
 */

/**
 *              4  12  5  3  1  2  5  3  1  2  4   6
 * new array => 12 -1  6  5  2  5  6  4  2  4  6  -1
 * 
 * (HERE WE ARE STORING ELEMENTS IN DECREASING ORDER IN THE MONOTONIC STACK)
 */

// OPTIMISED APPROACH
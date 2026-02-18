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

// OPTIMISED APPROACH
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
 * 4 12 5 3 1 2 5 3 1 2 4 6
 * new array => 12 -1 6 5 2 5 6 4 2 4 6 -1
 * 
 * (HERE WE ARE STORING ELEMENTS IN DECREASING ORDER IN THE MONOTONIC STACK)
 */

// OPTIMISED APPROACH WITH TIME COMPLEXITY AS O(2N) AND SPACE COMPLEXITY AS
// O(2N) ONE N IS FOR ARRAYLIST AND ANOTHER IS FOR STACK

class Solution2 {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // IF MY STACK HAS SOME ELEMENTS AND THE TOP IS LESS THAN CURRENT ELEMENT I.E.
            // ARR[i] THEN WE WILL REMOVE THE TOP ELEMENT

            // IT CAN BE PERFORMED SOMETIME FOR 3 ELEMENT SOMETIME FOR 2 AND MAX IT CAN BE
            // FOR N
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();

            // IF MY STACK IS EMPTY THEN WE ADD -1
            if (st.isEmpty())
                // HERE WE ARE STORING AS 0 BECAUSE WE WANT ANS AS LEFT-TO-RIGHT AND IN ARRAY 0
                // COMES AS START
                ans.add(0, -1);
            else
                ans.add(0, st.peek());

            st.push(arr[i]);
        }
        return ans;
    }
}
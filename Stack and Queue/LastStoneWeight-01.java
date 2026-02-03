// Question Link:- https://leetcode.com/problems/last-stone-weight/description/

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(n² log n) AND SPACE COMPLEXITY AS O(N) 
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();

        // CONVERT ARRAY TO LIST
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        // IT RUNS FOR O(n² log n) times
        // WHILE LOOP RUNS FOR O(N) TIME AND SORTING RUNS FOR O(NLOGN) TIMES
        while (list.size() > 1) {
            // SORT IN REVERSE ORDER
            // SORTING RUNS FOR O(nlogn times)
            Collections.sort(list, Collections.reverseOrder());

            int y = list.get(0); // largest
            int x = list.get(1); // second largest

            // remove both stones
            // here it will remove the index 0 i.e largest element of list and after that
            // second largest element comes at index 0 so thats why are again remove index 0
            // i.e. second largest element
            list.remove(0);
            list.remove(0);

            if (y != x) {
                list.add(Math.abs(x - y));
            }
        }
        if (list.size() == 0)
            return 0;
        else
            // Atlast we will get the answer in the list at the index 0 so thats why we are
            // returning list.get(0)
            return list.get(0);
    }
}

// OPTIMISED APPROACH WITH TIME COMPLEXITY AS O(nlogn) AND SPACE COMPLEXITY AS
// O(n)

/**
 * ARR=[2 7 4 1 8 1]
 * HERE WE WILL USE HEAP AND MAX HEAP FOR THE OPTMISED APPROACH
 * WE WILL CREATE A MAX HEAP AND AT START WE WILL ADD THE ELEMENT IN THE MAX
 * HEAP
 * WHENEVER WE POP FROM MAX HEAP IT WILL ALWAYS GIVE MAXIMUM ELEMENTS
 * FIRST WE POP X = 8, AND AFTER THAT Y = 7
 * AFTER THIS IF X != Y THEN WE WILL DO X-Y AND PUSH THE ANSWER OF X-Y INTO THE
 * MAX HEAP
 * THIS WILL CONTINUE TILL MY MAX HEAP HAS ONLY ONE ELEMENT OR NO ELEMENT
 */

class Solution2 {
    public int lastStoneWeight(int[] stones) {
        // MAX HEAP
        // IF WE DON't WRITE Collections.reverseOrder() THEN IT WORK AS MIN HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // ADDING ALL STONES
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        // HERE WHILE LOOP RUNS FOR N TIMES & POP/PUSH OPERATION RUNS FOR logN TIMES
        while (pq.size() > 1) {
            int x = pq.poll(); // REMOVING LARGEST
            // pq.poll();
            int y = pq.poll(); // REMOVING SECOND LARGEST
            // pq.poll();

            if (x != y)
                pq.add(Math.abs(x - y));
        }
        if (pq.size() == 0)
            return 0;
        else
            return pq.peek();
    }
}
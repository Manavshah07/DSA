// Question Link:- https://leetcode.com/problems/time-needed-to-buy-tickets/description/

// APPROACH WITH TIME COMPLEXITY AS O(N * MAXTICKET(i)) WHICH IS O(N * M) AND SPACE COMPLEXITY IS O(N) AS WE ARE USING QUEUE
import java.util.*;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();

        // ADD INDICES OF PEOPLE INTO THE QUEUE
        for (int i = 0; i < tickets.length; i++)
            q.add(i);

        // IT WILL CALCULATE EVERY SECOND WHEN NUMBER IS REMOVED FROM FRONT AND INSERTED
        // AT END
        int timeNeeded = 0;

        while (!q.isEmpty()) {

            int idFront = q.peek(); // FRONT PERSON
            q.poll(); // REMOVING THE FRONT PERSON FROM THE QUEUE
            tickets[idFront]--; // BUYS ONE TICKET

            // ONE SECOND PASSED
            timeNeeded++;

            // IF THIS IS PERSON K AND TICKETS BECOMES 0 THEN RETURN TIMENEEDED
            if (k == idFront && tickets[idFront] == 0)
                return timeNeeded;

            // IF STILL TICKETS LEFT THEN GO TO END OF QUEUE
            if (tickets[idFront] != 0)
                q.add(idFront);
        }
        return timeNeeded;
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(N)
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeNeeded = 0;

        /**
         * Eg:- 2 3 4 3 2 1 K = 3(index)
         */
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                // HERE THE ELEMENT LESS THEN K I.E. BEFORE INDEX 3 WILL SUBTRACT TILL K TIMES
                // People before or at k will buy up to tickets[k] times
                timeNeeded = timeNeeded + Math.min(tickets[i], tickets[k]);
            } else {
                // HERE THE ELEMENT GREATER THEN K I.E. AFTER INDEX 3 WILL SUBTRACT TILL K - 1
                // TIMES
                // People after k will buy up to tickets[k] - 1 times
                timeNeeded = timeNeeded + Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return timeNeeded;
    }
}
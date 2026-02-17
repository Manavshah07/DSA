// Question Link:-
// https://leetcode.com/problems/time-needed-to-buy-tickets/description/

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(1)

// APPROACH WITH TIME COMPLEXITY AS O(N * MAXTICKET(i)) WHICH IS O(N * M) AND SPACE COMPLEXITY IS O(N) AS WE ARE USING QUEUE
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
class Solution2 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {

                time = time + Math.min(tickets[i], tickets[k]);
            } else {
                //
                time = time + Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }
}
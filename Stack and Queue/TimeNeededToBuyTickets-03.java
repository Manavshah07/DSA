// Question Link:-
// https://leetcode.com/problems/time-needed-to-buy-tickets/description/

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS
// O(1)

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS 
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
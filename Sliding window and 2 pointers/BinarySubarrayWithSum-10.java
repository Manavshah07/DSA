// Question Link:- https://leetcode.com/problems/binary-subarrays-with-sum/ 

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0; // RESETTING THE SUM. IF I MOVES THEN WILL MAKE SUM AS 0
            for (int j = i; j < n; j++) {
                // HERE WE FIRST ONLY MOVE J SO THATS WHY ADD NUMS[J] WITH SUM
                sum += nums[j];

                if (sum == goal)
                    count++;
            }
        }
        return count;
    }
}

// OPTIMAL APPROACH
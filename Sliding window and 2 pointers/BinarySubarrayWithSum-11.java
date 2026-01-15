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

// [1 0 0 1 1 0] goal=2
// (HERE WITH THE HELP OF NORMAL WHERE WE ARE MOVING I AND J FROM START AND WE
// ARE MATCHING MY SUM == GOAL, IN THAT WE ARE NOT ABLE TO FIND THE ALL THE
// SUBARRAY WERE SUM = 2, SOME OF THEM ARE MISSING AS IT CONTAIN BINARY NUMBER
// OF 1 & 0 SO FOR THAT WE ARE DOING WITH ANOTHER APPROACH)

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(2 * 2N) AND SPACE COMPLEXITY AS
// O(1)
// IF ANY ISSUE WITH THE PROBLEM THEN CLICK HERE:-
// https://chatgpt.com/c/6967be0f-4fdc-8324-90fa-caeaf29b9758

// class Solution {
// // HERE WE WANT TO COUNT SUM == GOAL SO WE ARE NOT ABLE TO COUNT THAT
// DIRECTLY SO WE ARE DOING THIS
// public int numSubarraysWithSum(int[] nums, int goal) {
// return atMost(nums, goal) - atMost(nums, goal - 1);
// }

// public int atMost(int[] nums, int goal) {
// if (goal < 0) return 0;

// int i = 0, j = 0, sum = 0, count = 0;
// int n = nums.length;

// while(j < n) {
// sum += nums[j];

// while(sum > goal) {
// sum -= nums[i];
// i++;
// }
// // WITH THE HELP OF COUNT WE ARE CALCULATIING THE ATMOST AND SUBTRACTING IT
// // AS WE NEED SUM <= GOAL SO FOR THAT WE ARE CALCULATE IT BY ADDING INTO THE
// COUNT
// count += (j-i+1);
// j++;
// }
// return count;
// }
// }

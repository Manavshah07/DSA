// Question Link:- https://leetcode.com/problems/count-number-of-nice-subarrays/ 

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLXITY AS O(1)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0)
                    oddCount++;

                if (oddCount == k)
                    count++;
            }
        }
        return count;
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(2 * 2N) AND SPACE COMPLEXITY AS
// O(1)
// HERE WE WILL CONSIDER ALL ODD NUMBER AS 1 AND EVEN NUMBER AS 0
// IF ARRAYS IS 1,1,2,1,1 THEN IT WILL BECOME 1 1 0 1 1

// class Solution {
// public int numberOfSubarrays(int[] nums, int k) {
// return atMost(nums, k) - atMost(nums, k - 1);
// }

// public int atMost(int[] nums, int k) {
// if (k < 0) return 0;

// int i = 0, j = 0, sum = 0, count = 0;
// int n = nums.length;

// while(j < n) {
// // HERE IF THE NUMBER IS ODD THEN IT WILL BECOME 1 AND IF IT IS EVEN THEN IT
// WILL BECOME 0
// sum += (nums[j] % 2);

// while(sum > k) {
// sum -= (nums[i] % 2);
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
// Question Link:- https://leetcode.com/problems/max-consecutive-ones-iii/description/ 

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0)
                    zeros++;

                if (zeros <= k)
                    maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) + O(N) = O(2N) BECAUSE AT MAX
// ith INDEX WILL TRAVEL TILL LAST I.E. TILL N AND SPACE COMPLEXITY IS O(1)

// class Solution {
// public int longestOnes(int[] nums, int k) {
// int n = nums.length;
// int maxLength = 0, i = 0, j = 0,zeros = 0;

// while(j < n) {
// // IF ANY ZERO OCCUR THEN WE INCREMENT THE COUNT OF ZEROS
// if(nums[j] == 0)
// zeros++;

// // IF ANY ZERO OCCUR THEN WE DECREMNET THE COUNT OF ZEROS
// while(zeros > k) {
// if(nums[i] == 0)
// zeros--;
// i++;
// }

// if(zeros <= k)
// maxLength = Math.max(maxLength, j-i+1);
// j++;
// }
// return maxLength;
// }
// }

// MORE OPTIMISED APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS
// O(1)

// class Solution {
// public int longestOnes(int[] nums, int k) {
// int n = nums.length;
// int maxLength = 0, i = 0, j = 0, zeros = 0;

// while (j < n) {
// // IF ANY ZERO OCCUR THEN WE INCREMENT THE COUNT OF ZEROS
// if (nums[j] == 0)
// zeros++;

// // IF ANY ZERO OCCUR THEN WE DECREMNET THE COUNT OF ZEROS
// if (zeros > k) {
// if (nums[i] == 0)
// zeros--;
// i++;
// }

// if (zeros <= k)
// maxLength = Math.max(maxLength, j - i + 1);
// j++;
// }
// return maxLength;
// }
// }
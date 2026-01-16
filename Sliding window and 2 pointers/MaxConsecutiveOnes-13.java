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
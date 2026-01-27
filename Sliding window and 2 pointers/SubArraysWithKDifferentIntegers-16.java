// Question Link:-
// https://leetcode.com/problems/subarrays-with-k-different-integers/description/

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY WITH O(N)
import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            // HERE WE ARE USING HASHMAP FOR THE STORING THE NUMBER AND ITS FREQUENCY
            HashMap<Integer, Integer> hmap = new HashMap<>();
            for (int j = i; j < n; j++) {
                hmap.put(nums[j], hmap.getOrDefault(nums[j], 0) + 1);

                if (hmap.size() == k)
                    count++;
                else if (hmap.size() > k)
                    break;
            }
        }
        return count;
    }
}
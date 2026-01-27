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

// OPTIMAL APPROACH WITH TIME COMPLEXITY OF O(N) AND SPACE COMPLEXITY OF O(N)
// class Solution {
// public int subarraysWithKDistinct(int[] nums, int k) {
// // HERE IF WE DO ATMOST(K) - ATMOST(K-1) THEN WE GET ATMOST(K) DISTINCT VALUE
// return atMostK(nums, k) - atMostK(nums, k - 1);
// }

// private int atMostK(int[] nums, int k) {
// int n = nums.length;
// int i = 0, j = 0, count = 0;
// HashMap<Integer, Integer> hmap = new HashMap<>();
// while(j < n) {
// // ADDING ELEMENTS INTO THE HASHMAP
// hmap.put(nums[j], hmap.getOrDefault(nums[j], 0) + 1);

// // IF MAP SIZE IS GREATER THAN K
// while(hmap.size() > k) {
// // IF THE COUNT OF NUMBER IS GREATER THAN 1, THEN WE ARE REDUCING THE COUNT
// OF THAT NUMBER ELSE WE ARE REMOVING THAT NUMBER
// if(hmap.get(nums[i]) > 1)
// hmap.put(nums[i], hmap.get(nums[i]) - 1);
// else
// hmap.remove(nums[i]);
// i++;
// }
// j++;
// count = count + (j-i+1);
// }
// return count;
// }
// }
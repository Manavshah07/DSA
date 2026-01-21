// Question Link:- https://leetcode.com/problems/container-with-most-water/description/ 

/**
 * HERE FOR THE EXAMPLE 1
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 * IT IS 49 BECAUSE AS WE ARE TAKING FROM 8 TILL LAST I.E. 7 AND MINIMUM OF THAT
 * WILL BE 7 AS CONATINER IS THEIR OF HEIGHT 7 & 8 THEN WHATEVER WILL BE MINIMUM
 * TILL THAT IT WILL STORE, AFTER THAT WATER WILL OVERFLOW
 * FOR THE WIDTH IT WILL TAKE THE DISTANCE FROM 8 TO DISTANCE TILL 7. THEIR ARE
 * 7 DISTANCE FROM 8 TO 7 SO WE WILL CONSIDER WIDTH AS 7
 * FINAL ANSWER CALCUATION IS:- MIN(8, 7) * WIDTH = MIN(8, 7) * 7 = 49
 */

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS
// O(1)
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return ans;
    }
}

// OPTIMISED APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(1)
// AS NO EXTRA SPACE HAS BEEN USED
// class Solution {
// public int maxArea(int[] height) {
// int ans = 0;
// int left = 0;
// int right = height.length - 1;

// while(left < right) {
// // HERE WE ARE CALCUALTING MINIMUM OF LEFT & RIGHT AS WATER SHOULD NOT BE
// OVERFLOW AND AFTER THAT WE ARE DO RIGHT - LEFT TO CALCULATE THE DISTANCE
// BETWEEN LEFT & RIGHT
// ans = Math.max(ans, Math.min(height[left], height[right]) * (right-left));

// if(height[left] <= height[right])
// left++;
// else
// right--;
// }
// return ans;
// }
// }
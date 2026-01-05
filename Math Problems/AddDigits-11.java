// Question Link:- https://leetcode.com/problems/add-digits/submissions/1874363744/ 

// Time Complexity: O(1)
// Space Complexity: O(1) 
// the number of digit-sum iterations is bounded and independent of input size, and no extra space is used.
class Solution {
    public int addDigits(int num) {
        // WE HAVE DID num >=10 BECAUSE IF DIGIT IS MORE THAN ONE THEN ONLY DO
        // CALCUATIONS
        while (num >= 10) {
            int sum = 0;
            while (num != 0) {
                int rem = num % 10;
                sum += rem;
                num = num / 10;
            }
            // Now the new number becomes the sum
            num = sum; // replace num with the sum and repeat
        }
        return num;
    }
}

// Time Complexity: O(1)
// Space Complexity: O(1)
// public int addDigits(int num) {
// // WE HAVE DID num >=10 BECAUSE IF DIGIT IS MORE THAN ONE THEN ONLY DO
// // CALCUATIONS
// // special case
// if (num == 0)
// return 0;

// // digital root formula
// Digital root means final single digit you get after adding digits again and
// again.
// WE DID num - 1 because if my num is 9, 18, or 27 then it will give me 0 and
// we want 9 so for that reason we did num - 1
// return 1 + (num - 1) % 9;
// }

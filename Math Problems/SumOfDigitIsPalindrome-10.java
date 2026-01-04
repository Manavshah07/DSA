// User function Template for Java
// Question Link:- https://practice.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/1  

class Solution {
    boolean isDigitSumPalindrome(int n) {
        // code here
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum += rem;
            n = n / 10;
        }

        int original = sum;
        int reversed = 0;
        while (sum != 0) {
            int rem = sum % 10;
            reversed = reversed * 10 + rem;
            sum = sum / 10;
        }

        if (original == reversed)
            return true;
        else
            return false;
    }
}
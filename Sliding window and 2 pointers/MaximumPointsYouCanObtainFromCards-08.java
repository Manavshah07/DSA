// arr = [6  2  3  4  7  2  1  7  1]   K = 4
// Here what we need to do is we need to pick the element such that the length of the element should be equal to k and their sum should be maximum
// In the above eg if we can pick 4 element from start and store their sum in a variable sum.
// Also we can do is pick 3 element from start and 1 element from end and store their sum in a variable sum.
// Also we can do is pick 2 element from start and 2 element from end and store their sum in a variable sum.
// Also we can do is pick 1 element from start and 3 element from end and store their sum in a variable sum.
// Also we can do is pick 0 element from start and 4 element from end and store their sum in a variable sum.
// THis we can follow and whichever will be the maximum sum we can return that.

// leftSum = 15 [6 2 3 4]            rightSum = 0                OverallSum = 15
// leftSum = 11 [6 2 3]              rightSum = 1  [1]           OverallSum = 12
// leftSum = 08 [6 2]                rightSum = 8  [7 1]         OverallSum = 16
// leftSum = 06 [6]                  rightSum = 9  [1 7 1]       OverallSum = 14
// leftSum = 0                       rightSum = 11 [2 1 7 1]     OverallSum = 11

// Here We will be returning the maximum sum from this i.e 16

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(k^2) AND SPACE COMPLEXITY AS O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxLength = 0;

        for (int i = 0; i <= k; i++) {
            int leftCard = i; // i is no of cards taken from left
            // here we are calculating the cards which we will be taking from right
            // If we take 1 card from left then we will take k-i i.e. 4-1=3 card from right
            int rightCard = k - i;
            int sum = 0;

            // SUM WE ARE TAKING FROM LEFT SIDE
            for (int j = 0; j < leftCard; j++) {
                sum += cardPoints[j];
            }

            // SUM WE ARE TAKING FROM RIGHT SIDE
            for (int j = 0; j < rightCard; j++) {
                // AS WE WANT TO TAKE FROM LAST THATS WHY WE WROTE N-1
                sum += cardPoints[n - 1 - j];
            }
            maxLength = Math.max(maxLength, sum);
        }
        return maxLength;
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(2K) AND SPACE COMPLEXITY AS O(1)
// class Solution {
// public int maxScore(int[] cardPoints, int k) {
// int n = cardPoints.length;
// int leftSum = 0, rightSum = 0, maxLength = 0;

// // Eg:- arr = [6 2 3 4 7 2 1 7 1] K = 4

// // HERE WE HAVE ADDED ALL THE ELEMENTS FROM START TILL K
// // THIS TAKES TIME COMPLEXITY OF O(K)
// for (int i = 0; i < k; i++) {
// leftSum += cardPoints[i];
// maxLength = leftSum;
// }

// // HERE WE WILL REMOVE ALL THE ELEMENTS FROM K-1 TILL THE START ELEMENT LIKE
// // FIRST WE WILL REMOVE K-1TH INDEX THEN K-2 THEN K-3 AND K-4
// // AS WE START REMOVE ELEMENT FROM K-1 AFTER THAT WE WILL ALSO ADD THE
// ELEMENTS
// // FROM END I.E. FROM N-1
// // THIS TAKES TIME COMPLEXITY OF O(K)
// int rightIndex = n - 1;
// for (int i = k - 1; i >= 0; i--) {
// leftSum = leftSum - cardPoints[i];
// rightSum += cardPoints[rightIndex];
// rightIndex = rightIndex - 1; // HERE RIGHTINDEX SHOULD BE DECREMENTED AS WE
// NEED TO EXPLORE OTHER NUMBERS
// // ALSO
// maxLength = Math.max(maxLength, leftSum + rightSum);
// }
// return maxLength;
// }
// }

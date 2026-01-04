// User function Template for Java
// Question Link:-
// https://www.geeksforgeeks.org/problems/reversing-the-equation2205/1

// User function Template for Java
// TIME COMPLEXITY:- O(N) - EACH CHARACTER IS VISITED ONCE & SPACE COMPLEXITY:- O(N) - FOR THE OUTPUT STRING
class Solution {
    String reverseEqn(String S) {
        // your code here

        // WE WILL PUT OUR REVERSE EQUATION HERE IN ANS
        StringBuilder ans = new StringBuilder();
        int i = S.length() - 1;

        while (i >= 0) {
            // IF IT IS OPERATOR THEN WE ARE DIRECTLY ADDING TO THE ANS
            if (S.charAt(i) == '+' || S.charAt(i) == '-'
                    || S.charAt(i) == '*' || S.charAt(i) == '/') {
                ans.append(S.charAt(i));
            }

            // HERE WE ARE COLLECTING ALL NUMBERS TOGETHER IN TEMP
            StringBuilder temp = new StringBuilder();

            // IF NUMBERS ARE FOUND THEN ADD IN TEMP AND SEARCH FOR NEXT NUMBER
            while (i >= 0 && S.charAt(i) != '+' && S.charAt(i) != '-' && S.charAt(i) != '*' && S.charAt(i) != '/') {
                temp.append(S.charAt(i));
                i--;
            }

            // HERE WE ARE DOING I++ SO THAT MY NUMBER OR OPERATOR DON'T GET MISSED
            if (temp.length() > 0)
                i++;

            // WE COLLECTED DIGIT BACKWARD SO WE REVERSE THEM LIKE TEMP = "02" → REVERSE →
            // "20"
            ans.append(temp.reverse());
            i--;
        }
        return ans.toString();
    }
}
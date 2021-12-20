package dp;

/**
 * Step 1 : Take the string and tabulate it. i.e. row and column will have the same string.
 * Step 2 : First fill all 2 character indexs. For example is babad is the string, then mark all the indexs that cover 2 characters as palindrome or not.
 * Step 3 : For substrings greater than 2 length, the first and last characters should be same and internal substring should be a palindrome. Then mark that as palindrome
 * Step 4 : Get all the substrings having the highest length as longest palindrome substring.
 * Time Complexity is o(n^2)
 * Space Complexity is o(n^2)
 */
public class LongestPalindromeSubstring {

    public static void main ( String args [] ) {
        String inputString = "fabaf";
        // Construct a 2D array
        boolean [][] palindromeOrNot = new boolean[inputString.length()][inputString.length()];
        int maxLength = 0;
        int[] palindromeIndexes = {0,0};
        for(int r=0; r<palindromeOrNot[0].length; r++) {
            for(int c=0; c<palindromeOrNot.length; c++) {
                if(inputString.charAt(r) == inputString.charAt(c)) {
                    palindromeOrNot[r][c] = true;
                    if(Math.abs(c-r) > maxLength) {
                        maxLength = Math.abs(c-r);
                        palindromeIndexes = new int[]{r, c};
                    }
                }
            }
        }

        printPalindromeStrings(inputString, palindromeIndexes);

        printOutputTable(palindromeOrNot);
    }

    private static void printPalindromeStrings(String inputString, int[] palindromeIndexes) {
        System.out.println(palindromeIndexes[0] + " " + palindromeIndexes[1]);
        System.out.println(inputString.substring(palindromeIndexes[0], palindromeIndexes[1]+1));

    }

    private static void printOutputTable(boolean[][] palindromeOrNot) {
        for(int r=0; r<palindromeOrNot[0].length; r++) {
            for(int c=0; c<palindromeOrNot.length; c++) {
                System.out.print(palindromeOrNot[r][c] + " ");
            }
            System.out.println();
        }
        
    }
}

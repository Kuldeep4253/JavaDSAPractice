package String;

public class SpecialSubsequences {

    /***
     * You have given a string A having Uppercase English letters.
     *
     * You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.
     * Example Input
     * Input 1:
     *  A = "ABCGAG"
     * Input 2:
     *  A = "GAB"
     * Example Output
     * Output 1:
     *  3
     * Output 2:
     *  0
     */
    public static Long solve(String A) {
        int n = A.length();
        long ans = 0;
        int cnt_G[] = new int[n], count = 0;

        // Suffix count of G
        for(int i = n - 1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }

        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
            }
        }
        return ans;
    }
}

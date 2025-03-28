package BlindLeetCode75;

public class BlindProblem1 {
    /**
     * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
     * (i.e., t is concatenated with itself one or more times).
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     *
     * Example 1:
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     *
     * Example 2:
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     *
     * Example 3:
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     */

    public String gcdOfStrings(String str1, String str2) {
        if(str1.charAt(0)!=str2.charAt(0)){
            return "";
        }
        int gcdLength=findgcd(str1.length(),str2.length());
        // Check if the candidate divides both str1 and str2
        String candidate=str1.substring(0, gcdLength);
        if (isDivisible(str1, candidate) && isDivisible(str2, candidate)) {
            return candidate;
        }
        return "";
    }

    private int findgcd(int a, int b) {
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    private boolean isDivisible(String str, String sub) {
        if (str.length() % sub.length() != 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / sub.length(); i++) {
            sb.append(sub);
        }
        return sb.toString().equals(str);
    }

    public static void main(String...k){
        BlindProblem1 buildProblem=new BlindProblem1();
        System.out.println(buildProblem.gcdOfStrings("ABABAB","ABAB"));
    }
}

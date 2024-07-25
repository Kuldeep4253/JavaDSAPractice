package Array;

public class N3RepeatNumber {
    /*
    You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Note: Read-only array means that the input array should not be modified in the process of solving the proble
    Example Input
    Input 1:
            [1 2 3 1 1]
    Input 2:
            [1 2 3]
    Example Output
    Output 1: 1
    Output 2: -1
   Explanation 1:
1 occurs 3 times which is more than 5/3 times.
Explanation 2:
No element occurs more than 3 / 3 = 1 times in the array.
    */

    public int numbercount(int[] A){
        int count1 = 0;
        int count2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int j : A) {
            if (j == c1) {
                count1++;
            } else if (j == c2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                c1 = j;
            } else if (count2 == 0) {
                count2 = 1;
                c2 = j;
            } else {
                count1--;
                count2--;
            }
        }
        int size1 = 0;
        int size2 = 0;
        for (int j : A) {
            if (j == c1) {
                size1++;
            } else if (j == c2) {
                size2++;
            }
        }
        if(size1>(A.length/3))return c1;
        if(size2>(A.length/3))return c2;
        return -1;
    }

}

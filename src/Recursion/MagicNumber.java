package Recursion;

public class MagicNumber {
    /*
    Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit
recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1,
then the number is a magic number.
     */
    public int solve(int A) {
        int sum=sumElement(A);
        while(sum>9){
            sum=sumElement(sum);
        }
        if(sum==1){
            return 1;
        }
        return 0;
    }
    public int sumElement(int rem){
        if(rem>=0 && rem<=9){
            return rem;
        }
        return sumElement(rem/10)+ rem%10;
    }
    public static void main(String...k){
        MagicNumber mg=new MagicNumber();
        mg.solve(83557);
    }
}

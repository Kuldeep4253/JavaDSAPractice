package Array;

public class DecimalNearestPowerOf2 {

    public static void main(String...k){
        int a=4;
        int start=1;
        int powerOf2=0;

        while(a>=start){
            start=start*2;
            powerOf2++;
        }
        System.out.println(powerOf2-1);
    }
}

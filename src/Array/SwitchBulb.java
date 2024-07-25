package Array;

class SwitchBulb {
    public static int bulbs(int[] A) {
        boolean flag=false;
        int nxtswitch=0;
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==nxtswitch){
                count=count+1;
                nxtswitch=(nxtswitch+1)%2;
            }
        }

        return count;
    }

    public static void main(String...k){
        int arr[]={1, 1, 1, 1};
        System.out.println(bulbs(arr));
    }
}

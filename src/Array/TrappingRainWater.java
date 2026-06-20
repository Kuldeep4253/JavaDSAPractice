package Array;

public class TrappingRainWater {

    public static void main(String...k){

       int [] a={1,8,6,2,5,4,8,3,7};
       int [] left=new int [a.length];
       int [] right=new int [a.length];
       int min=Integer.MAX_VALUE;
       //Left max element
       for(int i=0;i<a.length;i++){
          if(i==0){
              left[i]=a[i];
          }
          else if(left[i-1]<a[i]){
              left[i]=a[i];
          }
          else{
              left[i]=left[i-1];
          }
       }
        //right max element
        for(int i=a.length-1;i>=0;i--){
            if(i==a.length-1){
                right[a.length-1]=a[a.length-1];
            }
            else if(right[i+1]<a[i]){
                right[i]=a[i];
            }
            else{
                right[i]=right[i+1];
            }
        }

        int trapWater=0;
        for(int i=0;i<a.length;i++){
            trapWater += Math.min(left[i], right[i]) - a[i];
        }
        System.out.println(trapWater);
    }
}

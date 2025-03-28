package Multithreading.ExampleBasic;

public class OddEvenPrintThread {
    public static void main(String...k){


        // Odd Thread Creation using lambda

        Thread oddPrinter=new Thread(()->{
            for(int i=0;i<100;i++){
                if(i%2!=0){
                    System.out.println("Odd is printing:"+i+" Thread Name"+Thread.currentThread().getName());
                }
            }
        });

        // Even Thread Creation
        Thread evenPrinter=new Thread(()->{
            for(int i=0;i<100;i++){
                if(i%2==0){
                    System.out.println("Even is printing:"+i+" Thread Name"+Thread.currentThread().getName());
                }
            }
        });

        oddPrinter
                .start();
        evenPrinter
                .start();

        try{
            oddPrinter.join();
            evenPrinter.join();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

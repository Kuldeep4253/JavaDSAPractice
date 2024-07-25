package Multithreading;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        //task thread
        for(int i=10;i>0;i--){
            System.out.println("Value of Another Thread i:"+i);
            try{Thread.sleep(2000);}catch (Exception e){System.out.println(e);}
        }
    }

    public static void main(String[] args){
        AnotherThread t1=new AnotherThread();
        AnotherThread t2=new AnotherThread();
        t1.start();
        t2.start();


    }
}

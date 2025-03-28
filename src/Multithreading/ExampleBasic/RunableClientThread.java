package Multithreading.ExampleBasic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunableClientThread {
    public static void main(String...k){
        RunableThread runableThread=new RunableThread();
        Thread t=new Thread(runableThread);
        //ExecutorService ex= Executors.newFixedThreadPool(2);
       // ex.execute(t);
        //ex.shutdown();
        t.start();

    }
}

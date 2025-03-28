package Multithreading.ExampleBasic;

import jdk.jshell.EvalException;

import java.util.concurrent.*;

public class CallableCall {
    public static void main(String...k){
        ExecutorService ex= Executors.newFixedThreadPool(1);
        Callable<Integer> task=()->{
            Thread.sleep(5000);
          return 20;
        };

        Future<Integer> fs=ex.submit(task);
        try{
            System.out.println(Thread.currentThread().getName());
            Integer result=fs.get();
            System.out.println(result);
            ex.shutdown();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

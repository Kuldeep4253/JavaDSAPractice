package Thread;

class PrintEvenOddNumber implements Runnable{
    static int counter=0;
    Object lock;

    public void printer(){
        System.out.println(Thread.currentThread().getName()+" "+counter);
        counter++;
    }
    PrintEvenOddNumber(Object obj){
        this.lock=obj;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(counter<=10){
            if(counter%2==0 && Thread.currentThread().getName().equals("Even Thread")){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" Value is "+counter);
                    counter++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if(counter%2!=0 && Thread.currentThread().getName().equals("Odd Thread")){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" Value is "+counter);
                    counter++;
                   lock.notifyAll();
                }
            }
        }

            }

    }

public class EvenOddCommonMethod{
    public static void main(String...k){
        Object lock=new Object();
        PrintEvenOddNumber even=new PrintEvenOddNumber(lock);
        PrintEvenOddNumber odd=new PrintEvenOddNumber(lock);

        Thread t2=new Thread(odd,"Odd Thread");
        Thread t1=new Thread(even,"Even Thread");
        t2.start();
        t1.start();

    }
}



package Thread;

import java.util.LinkedList;
import java.util.Queue;

/*
Create Shared Queue to produce and consume item and assumption : if queue is full then can not be produce item and
Queue is empty then can not be consume the item
 */
public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;


    public SharedResource( int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produceItem(int item ) throws Exception{
        if(sharedBuffer.size()==bufferSize){
            System.out.println("Buffer is full ,can not produce item:{} "+item);
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("item is produced :"+item);
        Thread.sleep(1000);
        notify();
    }

    public synchronized int consumeItem( ) throws Exception{
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty ,can not consume item:{}");
            wait();
        }
        int item=sharedBuffer.peek();
        sharedBuffer.remove();
        System.out.println("item is consumed :"+item);
        notify();
        Thread.sleep(1000);
        return item;
    }
}

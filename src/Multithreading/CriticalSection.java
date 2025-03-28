package Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class CriticalSection {
    private final Queue<Integer> queue;
    private final int limit;
    private final Semaphore empty;  // Counts empty slots
    private final Semaphore full;   // Counts full slots
    private final Semaphore mutex;  // Controls access to the queue

    public CriticalSection(int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
        this.empty = new Semaphore(limit); // Initially, all slots are empty
        this.full = new Semaphore(0);      // Initially, there are no full slots
        this.mutex = new Semaphore(1);     // Only one thread can access the queue at a time
    }

    public void produce(int value) throws InterruptedException {
        empty.acquire();  // Wait for an empty slot
        mutex.acquire();  // Enter critical section

        queue.add(value);
        System.out.println("Produced: " + value);

        mutex.release();  // Exit critical section
        full.release();   // Signal that there's a new full slot
    }

    public void consume() throws InterruptedException {
        full.acquire();   // Wait for a full slot
        mutex.acquire();  // Enter critical section

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        mutex.release();  // Exit critical section
        empty.release();  // Signal that there's a new empty slot
    }
}

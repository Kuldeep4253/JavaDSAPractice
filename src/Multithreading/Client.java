package Multithreading;

public class Client {
    public static void main(String... k) {
        CriticalSection sharedResource = new CriticalSection(3);

        // Producer thread
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 6; i++) {
                    sharedResource.produce(i);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Consumer thread
        Thread consumeThread = new Thread(() -> {
            try {
                for (int i = 0; i <= 6; i++) {
                    sharedResource.consume();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumeThread.start();

        try {
            producerThread.join();
            consumeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

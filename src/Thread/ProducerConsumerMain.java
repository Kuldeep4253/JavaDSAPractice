package Thread;

public class ProducerConsumerMain {
    public static void main(String...k){

        SharedResource sharedResource=new SharedResource(3);
        // Creating Producer Thread TO produce the item
        Thread producerThread=new Thread(()->{
            try{
                for(int i=0;i<=6;i++){
                    sharedResource.produceItem(i);
                }

        } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        // Creating Consumer Thread T1 consume the item
        Thread consumeThread=new Thread(()->{
            try{
                for(int i=0;i<=6;i++){
                    sharedResource.consumeItem();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        producerThread.start();
        consumeThread.start();
    }
}

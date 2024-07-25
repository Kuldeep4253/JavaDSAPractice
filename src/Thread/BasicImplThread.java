package Thread;

public class BasicImplThread extends Thread{

    @Override
    public void run()
    {
        System.out.println("Now the thread is running ...");
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println("Number is even and executed by "+i);
            }
        }
        System.out.println("Now the thread is Stop ...");
    }

    public static void main(String...k) throws InterruptedException {
        BasicImplThread btl=new BasicImplThread();
        BasicImplThread btl2=new BasicImplThread();
        System.out.println("Name:"+btl.getName()+" Id "+btl.getId()+" State "+btl.getState());
        btl.setName("my thread KS");
        btl.sleep(1000);
        System.out.println("Name:"+btl.getName()+" Id "+btl.getId()+" State "+btl.getState());
        btl.start();
        btl2.start();
    }

}

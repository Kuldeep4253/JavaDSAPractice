package Multithreading;

public class MainThread {
    public static void main(String[] args){
        Company comp=new Company();
        Producer pd=new Producer(comp);
        Consumer con=new Consumer(comp);
        pd.start();
        con.start();
    }
}

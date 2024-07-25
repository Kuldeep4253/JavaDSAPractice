package SingeltonPattern;

import java.lang.ref.Reference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Employee {

    private static Employee singelton_object=null;


    private Employee(){
        if(singelton_object!=null){
            throw new RuntimeException("You are trying to break singleton object");

        }
    }

    public synchronized static Employee getSingelton_object() {
        /*
        To make method synchronized to low the performance bcz method should access by single thread
        so try to identified and put the code where it can be lead race condotion or use synchronized block
         */
        if(singelton_object==null) {
            synchronized (Employee.class) {
                if (singelton_object == null) {
                    singelton_object = new Employee();
                }
            }
        }
        return singelton_object;
    }

}

class Test {
    // Main driver method
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Instantiating Singleton class with variable x
        Employee x = Employee.getSingelton_object();

        Class c=Class.forName("SingeltonPattern.Employee");
        Constructor cons1=c.getDeclaredConstructor();
        cons1.setAccessible(true);

        // Instantiating Singleton class with variable y
        Employee y = Employee.getSingelton_object();

        // Instantiating Singleton class with variable z
        Employee z = Employee.getSingelton_object();

        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                + x.hashCode());
        System.out.println("Hashcode of y is "
                + y.hashCode());
        System.out.println("Hashcode of z is "
                + z.hashCode());
        Employee emp1=(Employee) cons1.newInstance();
        System.out.println("Hashcode of emp1 is "
                + emp1.hashCode());

        // Condition check
        if (x == y && y == z) {

            // Print statement
            System.out.println(
                    "Three objects point to the same memory location on the heap i.e, to the same object");
        }

        else {
            // Print statement
            System.out.println(
                    "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}

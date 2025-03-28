package Design.Singleton;

import java.io.*;

public class DeserializationBreakSingleton {
    /***
     * To prevent to break singleton from serialization and deserialization to implement read resolve method
     * @param k
     */
    public static void main(String...k) {
        try {
            LazySingleton instance1 = LazySingleton.getINSTANCES();
            ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(
                    new FileInputStream("file.text"));

            LazySingleton instance2
                    = (LazySingleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

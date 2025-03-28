package Design.Singleton;

import java.lang.reflect.Constructor;

public class ReflectionBreakSingleton {

    public static void main(String...k){
        LazySingleton lazySingleton1=LazySingleton.getINSTANCES();
        LazySingleton lazySingleton2=null;
        try {
            Constructor[] constructors
                    = LazySingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // Below code will destroy the singleton
                // pattern
                constructor.setAccessible(true);
                lazySingleton2
                        = (LazySingleton) constructor.newInstance();
                break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    /***
     * 1. We can prevent to break singleton pattern through Reflection so try to add check on constructor
     * if object exist and anyone want to create it it throws exception
     *
     * 2.
     */



}

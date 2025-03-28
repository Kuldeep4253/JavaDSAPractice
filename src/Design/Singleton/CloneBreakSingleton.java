package Design.Singleton;

public class CloneBreakSingleton {
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        LazySingleton instance1 = LazySingleton.getINSTANCES();
        LazySingleton instance2 = (LazySingleton) instance1.clone();
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}

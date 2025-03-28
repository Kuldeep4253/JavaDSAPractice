package Design.Singleton;

public class EagerSingleton {

    /**
     * 1. lazy intialization
     * 2. Eager intialization  --> through static and final keyword intialze only at a class load time
     * 3. Enum Based
     * 4. Static block
     */

    private static final EagerSingleton INSTANCES=new EagerSingleton();

    private EagerSingleton(){
        if (INSTANCES != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }
    // implement readResolve method
    protected Object readResolve() { return INSTANCES; }

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public static EagerSingleton getInstance(){
        return INSTANCES;
    }
}

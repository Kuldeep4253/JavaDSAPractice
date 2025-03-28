package Design.Singleton;

public class LazySingleton {
    private static LazySingleton INSTANCES=null;

    private LazySingleton(){
        if (INSTANCES != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }
    // implement readResolve method to prevent breaking singleton through serializable and deserializable
    protected Object readResolve() { return INSTANCES; }

    // oveeride clone method to prevent breaking singleton through clonable object through clone method
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public static LazySingleton getINSTANCES() {
        if(INSTANCES==null){
            synchronized (LazySingleton.class){
                if(INSTANCES==null){
                    INSTANCES=new LazySingleton();
                }
            }
        }
        return INSTANCES;
    }
}

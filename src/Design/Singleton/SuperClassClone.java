package Design.Singleton;

import java.lang.constant.ClassDesc;

public class SuperClassClone implements Cloneable {
    int i = 10;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

package ReflectionConcepts;

import java.lang.reflect.Method;

public class ReflectionImpl {


    private String name;
    public ReflectionImpl(){
        System.out.println("Hello Constructor");
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}

 class main{

    public static void main(String[] k) throws Exception{

        ReflectionImpl reflection=new ReflectionImpl();
        //reflection.setName("kuldeep");
        Class  c=Class.forName("ReflectionConcepts.ReflectionImpl");
        ReflectionImpl reflection1=(ReflectionImpl) c.newInstance();
        Method m=c.getDeclaredMethod("setName",String.class);
        m.setAccessible(true);
        m.invoke(reflection1,"kuldeep");
        System.out.println(reflection1.getName());





    }

}




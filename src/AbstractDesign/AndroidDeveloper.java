package AbstractDesign;

public class AndroidDeveloper implements Employee{
    /**
     *
     */
    @Override
    public int salary() {
        System.out.println("AndroidDeveloper Salary :");
        return 5000;
    }

    /**
     *
     */
    @Override
    public String name() {
        System.out.println("AndroidDeveloper name :");
        return "Android Developer";
    }
}

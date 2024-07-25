package AbstractDesign;

public class WebDeveloper implements Employee{
    /**
     * @return
     */
    @Override
    public int salary() {
        System.out.println("Web Developer Salary :");
        return 6000;
    }

    /**
     *
     */
    @Override
    public String name() {
        System.out.println("AndroidDeveloper name :");
        return "Web Developer";
    }
}

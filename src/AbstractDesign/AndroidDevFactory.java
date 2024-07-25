package AbstractDesign;

public class AndroidDevFactory extends EmployeeAbstract{

    /**
     * @return
     */
    @Override
    public Employee createEmployee() {
        return new AndroidDeveloper();
    }
}

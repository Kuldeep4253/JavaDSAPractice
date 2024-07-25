package AbstractDesign;

public class WebDevFactory extends EmployeeAbstract{

    /**
     * @return
     */
    @Override
    public Employee createEmployee() {
        return new WebDeveloper();
    }
}

package AbstractDesign;

public class EmployeeFactory {

    public static Employee getEmployee(EmployeeAbstract emp){
        return emp.createEmployee();
    }
}

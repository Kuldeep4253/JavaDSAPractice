package AbstractDesign;

public class client {

    public static void main(String...k){

        Employee emp1=EmployeeFactory.getEmployee(new AndroidDevFactory());
        emp1.salary();
        Employee emp2=EmployeeFactory.getEmployee(new WebDevFactory());
        emp2.salary();


    }
}

package Exception;

public class AgeValidation {

    public void ageValidator(int age) throws AgeInvalidCustome {
        if(age<18){
            throw new AgeInvalidCustome("Age is below 18...");
        }
        else{
            System.out.println("Age is good");
        }
    }
    public static void main(String...k) throws AgeInvalidCustome {
        AgeValidation ag=new AgeValidation();
        ag.ageValidator(15);
    }

}

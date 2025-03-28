package Generics;

public class CreditCardType <T>{

    private T typeCreditCard;

    // Constructor to initialize the type of credit card
    public CreditCardType(T typeCreditCard) {
        this.typeCreditCard = typeCreditCard;
    }

    public T getTypeCreditCard() {
        return typeCreditCard;
    }

    public void setTypeCreditCard(T typeCreditCard) {
        this.typeCreditCard = typeCreditCard;
    }
    // Main method to test the generic class
    public static void main(String[] args) {
        // Example with String as the type of credit card
        CreditCardType<String> visaCard = new CreditCardType<>("Visa");
        System.out.println("Credit card type: " + visaCard.getTypeCreditCard());

        // Example with Integer as the type of credit card (could be a credit card number)
        CreditCardType<Integer> cardNumber = new CreditCardType<>(123456789);
        System.out.println("Credit card number: " + cardNumber.getTypeCreditCard());
    }
}

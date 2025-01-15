/*
 NonMember class: A NonMember object represents a passenger who is not a frequent flyer
member. This class has no instance variables.
This class extends the Passenger class and overrides the applyDiscount(double p) method as
follows. If the age of the person is more than 65, 10% discount will be applied. Otherwise no discount
 */



public class NonMember extends Passenger {
    public NonMember(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double p) {
        if (getAge() > 65) {
            return p * 0.9;
        } else {
            return p;
        }
    }
    

    

}

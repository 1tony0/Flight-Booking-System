/*
 III. Passenger class: This is an abstract class. The subclasses of this class are: Member and
NonMember. The class has attributes common to all kinds of passengers. It contains two instance
variables:
• name of type String
• age of type int

This class should have a constructor for initializing the instance variables, getters and setters for each
instance variable. This class also has an abstract method double applyDiscount(double p).
This method should be overridden by both the subclasses. In the subclasses, this applyDiscount
method should return a price after applying the appropriate discount.
 */

public class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public double applyDiscount(double p) {
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}

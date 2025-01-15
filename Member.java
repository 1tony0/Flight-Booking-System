/*
 IV. Member class: A Member object represents a frequent flyer member. This class has one instance
variable:
• yearsOfMembership of type int
This class extends the Passenger class and overrides the applyDiscount(double p) method as
follows. If the member has membership for more than 5 years, then 50% discount will be applied. If the
member has membership for more than 1 year but less than or equal to 5 years, then 10% discount will
be applied. Otherwise no discount
 */


public class Member extends Passenger {
    private int yearsOfMembership;

    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }

    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) {
            return p * 0.5;
        } else if (yearsOfMembership > 1) {
            return p * 0.9;
        } else {
            return p;
        }
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
}

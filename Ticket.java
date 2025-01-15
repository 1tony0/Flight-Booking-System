/*
 II. Ticket class: This class represents a flight ticket.
This class has four instance variables:
o passenger of type Passenger
o flight of type Flight
o price of type double
o number of type int. Each Ticket has a unique ticket number (the first Ticket has ticket
number 1, the second has ticket number 2, etc. (Hint: implementing this will require
adding a static variable.)
This class should:
• have a constructor that takes three parameters: Passenger p, Flight flight, double price. It
should initialize all the instance variables accordingly.
• getters and setters for each instance variable.
• override the toString() method that returns a String representation of a Ticket object. The
String should include the passenger’s name, information about the flight (e.g. the flight num-
ber, the origin, the destination, the departure, and the original price) and the actual ticket
price. e.g., "Julia Chow, Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price:
1000$, ticket price: $600.00"
 */

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int ticketNumber = 1;

    public Ticket(Passenger passenger, Flight flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.number = ticketNumber;
        ticketNumber++;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return passenger.getName() + ", " + flight.toString() + ", ticket price: $" + price;
    }
    
}

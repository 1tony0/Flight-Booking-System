/*
 (a) Implementing the Flight class:
Each object of this class represents a flight. The Flight class consists of instance variables, a constructor
and instance methods.
This class has seven instance variables:







This class should have:
• a constructor that initializes the instance variables. It takes six parameters. If the specified origin
and destination are equal, an IllegalArgumentException should be thrown to abort the construc-
tion. The numberOfSeatsLeft variable is initialized depending on the specified capacity.
• getters and setters for each instance variable.
Page 2 of 4
• a bookASeat() method. If the numberOfSeatsLeft is greater than 0, this method decrements
the numberOfSeatsLeft variable and returns true. Otherwise, it returns false.
This class should override the toString method that returns a String representation of a Flight
object. The String should include the flight number, the origin, the destination, the departure time
and the original price. e.g., "Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price:
1000$"
 */



//package lab1;

public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    public char[] getOrigin;

    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
        if (origin.equals(destination)) {
            throw new IllegalArgumentException("Origin and destination cannot be the same!!");
        }
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public boolean bookASeat() {
        if (numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;
            return true;
        }
        return false;
    }


    //this is just to test if the thing works
    
    /*public static void main(String[] args) {
        Flight f = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 100, 1000);
        System.out.println(f);
    }
        */

    @Override
    public String toString() {
        return "Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", original price: " + originalPrice + "$";
    }
}
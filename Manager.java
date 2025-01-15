/*
  Manager class: A Manager object manages the flights of a specific airline. It maintains an array of
flights and an array of issued tickets. It should have the following methods:
• public void createFlights(): this method should populate the array of flights. This
method should ask the user to input information about the flights. (Hint: use Scanner class).
• public void displayAvailableFlights(String origin, String desti-
nation): this method should display all the available flights from origin to destination. It
should display only those flights that are not yet fully booked.
• public Flight getFlight(int flightNumber): this method should return the
Flight object for the specified flight number.
• public void bookSeat(int flightNumber, Passenger p): This method first
tries to find a flight for the given flight number. If such flight exists, then it tries to book a seat
in that flight. If booking is successful, then applies the appropriate discount on the price de-
pending on the passenger being a member or a non-member (Polymorphism works here). Final-
ly, it issues a ticket with the appropriate price.
• public static void main(String[] args): this method should call all the other
methods of the Manager class to see if they work. You are responsible for developing a con-
vincing plan for the main method, i.e., for convincing the TA that your methods work
properly.
use array list
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;
    public ArrayList<Ticket> cart = new ArrayList<>();

    public Manager() {
        flights = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void createFlights() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of flights: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {


            //flight method
            System.out.println("Enter the flight number: ");
            int flightNumber = sc.nextInt(); sc.nextLine();
            System.out.println("Enter the origin: ");
            String origin = sc.next(); sc.nextLine();
            System.out.println("Enter the destination: ");
            String destination = sc.next(); sc.nextLine();
            System.out.println("Enter the departure time: ");
            String departureTime = sc.next(); sc.nextLine();
            System.out.println("Enter the capacity: ");
            int capacity = sc.nextInt(); sc.nextLine();
            System.out.println("Enter the original price: ");
            double originalPrice = sc.nextDouble(); sc.nextLine();
            Flight flight = new Flight(flightNumber, origin, destination, departureTime, capacity, originalPrice);
            flights.add(flight);
        }
    }

    public List<Flight> getAvailableFlights(String origin, String destination) {
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getNumberOfSeatsLeft() > 0) {
                availableFlights.add(flight);
            }
        }
        return availableFlights;
    }

    public void displayAvailableFlights(String origin, String destination) {
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getNumberOfSeatsLeft() > 0) {
                System.out.println(flight);
            }
        }
    }

    public Flight getFlight(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public void bookSeat(int flightNumber, Passenger p) {
        Flight flight = getFlight(flightNumber);
        if (flight != null) {
            if (flight.bookASeat()) {
                double price = flight.getOriginalPrice();
                if (p instanceof Member) {
                    price = ((Member) p).applyDiscount(price);
                } else if (p instanceof NonMember) {
                    price = ((NonMember) p).applyDiscount(price);
                }
                Ticket ticket = new Ticket(p, flight, price);
                tickets.add(ticket);
            }
        }
    }



//task is to make this into a possible drop down menu options where I can simply just let the user deciede if they would like to whatever the user wants to do.






    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Select an option:");
            System.out.println("1) End the code");
            System.out.println("2) Add a flight/create flight");
            System.out.println("3) Display available flights");
            System.out.println("4) Book seats");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    running = false;
                    break;
                case 2:
                    manager.createFlights();
                    break;
                case 3:
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    List<Flight> availableFlights = manager.getAvailableFlights(origin, destination);
                    if (availableFlights.isEmpty()) {
                        System.out.println("No available flights.");
                    } else {
                        for (Flight flight : availableFlights) {
                            System.out.println(flight);
                        }
                    }
                    break;
                case 4:
                    boolean booking = true;
                    while (booking) {
                        System.out.print("Enter flight number: ");
                        int flightNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Flight flight = manager.getFlight(flightNumber);
                        if (flight == null) {
                            System.out.println("Flight number does not exist.");
                            continue;
                        }
                        System.out.print("Enter passenger type (member/non-member): ");
                        String passengerType = scanner.nextLine();
                        Passenger passenger;
                        if (passengerType.equalsIgnoreCase("member")) {
                            System.out.print("Enter member name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter member age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter member years of membership: ");
                            int yearsOfMembership = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            passenger = new Member(name, age, yearsOfMembership);
                        } else {
                            System.out.print("Enter non-member name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter non-member age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            passenger = new NonMember(name, age);
                        }
                        manager.bookSeat(flightNumber, passenger);
                        double price = flight.getOriginalPrice();
                        if (passenger instanceof Member) {
                            price = ((Member) passenger).applyDiscount(price);
                        } else if (passenger instanceof NonMember) {
                            price = ((NonMember) passenger).applyDiscount(price);
                        }
                        System.out.println("Price: " + price);
                        System.out.print("Would you like to book another seat? (yes/no): ");
                        String response = scanner.nextLine();
                        Ticket ticket = new Ticket(passenger, flight, price);
                        manager.cart.add(ticket);
                        if (response.equalsIgnoreCase("no")) {
                            booking = false;
                            running = false;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        double totalAmount = 0;
        System.out.println("Your cart:");
        for (Ticket ticket : manager.cart) {
            System.out.println(ticket);
            totalAmount += ticket.getPrice();
        }
        System.out.println("Total amount: " + totalAmount);

        scanner.close();
    }
}
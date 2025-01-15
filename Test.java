
/*
 (b) Testing the Flight class (use JUnit 4):
Once the Flight class has no compilation errors:
• Write the code for the junit test method testConstructor() that tests the constructor
by providing it with valid arguments.
• Write a JUnit test method testInvalidConstructor() that tests the constructor
with invalid arguments. The test should pass only if an IllegalArgumentException is thrown.
• Test the public methods that include all the getters, setters, the bookASeat() method and the
toString() method, using Junit
 */

public class Test {
    public static void main(String[] args) {

        //Workign test with constructor:
        Flight flight = new Flight(1030, "Toronto", "Punta Cana", "03/02/99 7:50 pm", 100, 1000);
        System.out.println(flight);

        //Invalid constructor test:
        try {
            Flight flight2 = new Flight(1030, "Toronto", "Punta Cana", "03/02/99 7:50 pm", 100, -1000); //should be invalid due to 1000
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid constructor test passed");
        }
    
       //Testing getters and setters
        flight.setCapacity(200);
        System.out.println(flight.getCapacity());
        flight.setNumberOfSeatsLeft(150);
        System.out.println(flight.getNumberOfSeatsLeft());
        flight.setOriginalPrice(2000);
        System.out.println(flight.getOriginalPrice());
        flight.setDepartureTime("03/02/99 7:50 pm");
        System.out.println(flight.getDepartureTime());
        flight.setDestination("Punta Cana");
        System.out.println(flight.getDestination());
        flight.setOrigin("Toronto");
        System.out.println(flight.getOrigin());
        System.out.println(flight.bookASeat());
        System.out.println(flight.toString());
    }
    


    
}


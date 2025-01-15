# Flight Booking System

This project is a simple flight booking system implemented in Java. It allows users to create flights, display available flights, and book seats on flights. The system supports both members and non-members, with members receiving a discount on flight prices.

## Features

1. **End the Code**: Exit the application.
2. **Add a Flight/Create Flight**: Use the `createFlights` method to add new flights to the system.
3. **Display Available Flights**: Ask the user for the origin and destination, and display all available flights that match the criteria.
4. **Book Seats**: Allow users to book seats on a flight. Users can specify whether they are a member or non-member, and the system will apply the appropriate discount. Users can add multiple bookings to their cart and view the total amount owed at checkout.

## Classes

- **Manager**: Manages the list of flights and handles user interactions.
- **Flight**: Represents a flight with details such as origin, destination, flight number, and price.
- **Passenger**: Base class for passengers.
- **Member**: Subclass of `Passenger` representing a member with a discount.
- **NonMember**: Subclass of `Passenger` representing a non-member.
- **Ticket**: Represents a booked ticket with passenger details and price.

## Usage

1. **Run the Application**: Execute the `main` method in the `Manager` class.
2. **Select an Option**: Follow the on-screen prompts to select an option:
   - Enter `1` to end the code.
   - Enter `2` to add a flight.
   - Enter `3` to display available flights.
   - Enter `4` to book seats.
3. **Book Seats**: If booking seats, follow the prompts to enter flight number and passenger details. You can book multiple seats and view the total amount owed at checkout.

## Example

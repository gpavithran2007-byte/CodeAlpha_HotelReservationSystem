import java.util.ArrayList;
import java.util.Scanner;

// Room class to store room details
class Room {
    int roomNumber;
    String category;
    double price;
    boolean booked;

    // Constructor
    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Creating some rooms in the hotel
        rooms.add(new Room(101, "Standard", 1000));
        rooms.add(new Room(102, "Standard", 1000));
        rooms.add(new Room(201, "Deluxe", 2000));
        rooms.add(new Room(202, "Deluxe", 2000));
        rooms.add(new Room(301, "Suite", 3000));

        int choice;

        do {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            if (choice == 1) {
                showAvailableRooms();
            } 
            else if (choice == 2) {
                bookRoom();
            } 
            else if (choice == 3) {
                cancelBooking();
            } 
            else if (choice == 4) {
                System.out.println("Thank you for using the system.");
            } 
            else {
                System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);
    }

    // Display rooms that are not booked
    static void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            if (!room.booked) {
                System.out.println("Room " + room.roomNumber +
                        " | " + room.category +
                        " | Price: ₹" + room.price);
            }
        }
    }

    // Book a room
    static void bookRoom() {
        System.out.print("Enter the room number you want to book: ");
        int roomNumber = scanner.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.booked) {
                room.booked = true;
                System.out.println("Room booked successfully!");
                return;
            }
        }

        System.out.println("Sorry, that room is not available.");
    }

    // Cancel booking
    static void cancelBooking() {
        System.out.print("Enter the room number to cancel booking: ");
        int roomNumber = scanner.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.booked) {
                room.booked = false;
                System.out.println("Booking cancelled successfully.");
                return;
            }
        }

        System.out.println("No booking found for that room.");
    }
}

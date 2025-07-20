// Hotel Reservation System - Java Console Project

import java.util.*;

public class HotelReservationSystem {
    static Scanner scanner = new Scanner(System.in);

    static class Room {
        int number;
        String category;
        boolean isBooked;

        Room(int number, String category) {
            this.number = number;
            this.category = category;
            this.isBooked = false;
        }
    }

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        initRooms();
        int choice;
        do {
            System.out.println("\n🏨 Hotel Reservation System Menu");
            System.out.println("1. View All Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> bookRoom();
                case 3 -> cancelBooking();
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void initRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Standard"));
        rooms.add(new Room(105, "Deluxe"));
    }

    static void viewRooms() {
        System.out.println("\n📋 Room List:");
        for (Room r : rooms) {
            String status = r.isBooked ? "Booked" : "Available";
            System.out.println("Room " + r.number + " (" + r.category + ") - " + status);
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number to book: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (Room r : rooms) {
            if (r.number == num) {
                if (!r.isBooked) {
                    r.isBooked = true;
                    System.out.println("✅ Room " + num + " booked successfully!");
                } else {
                    System.out.println("❌ Room is already booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }

    static void cancelBooking() {
        System.out.print("Enter room number to cancel booking: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (Room r : rooms) {
            if (r.number == num) {
                if (r.isBooked) {
                    r.isBooked = false;
                    System.out.println("✅ Booking for Room " + num + " cancelled.");
                } else {
                    System.out.println("❌ Room is not currently booked.");
                }
                return;
            }
        }
        System.out.println("Room not found.");
    }
}

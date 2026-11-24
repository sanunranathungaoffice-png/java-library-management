package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Staff;
import lms.model.Student;
import lms.service.Library;

/**
 * Entry point demonstrating Object-Oriented Programming concepts in a Library Management System.
 */
public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Populate catalog items
        library.addItem(new Book("B001", "Clean Code", "Robert C. Martin"));
        library.addItem(new Book("B002", "Effective Java", "Joshua Bloch"));
        library.addItem(new DVD("D001", "Introduction to Algorithms", 120));

        // Register members with role-based borrowing limits
        library.addMember(new Student("M001", "Nadeesha Perera"));
        library.addMember(new Staff("M002", "Mr. Kasun Silva"));

        // Display catalog, members, and polymorphic late-fee calculations
        library.listItems();
        library.listMembers();
        library.printAllLateFees(3);

        // Demonstrate input validation and exception handling
        try {
            new Book("B003", "", "Unknown Author");
        } catch (IllegalArgumentException ex) {
            System.out.println("Rejected invalid book: " + ex.getMessage());
        }
    }
}

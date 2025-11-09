import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryManagementSystem {

    // The list holds 'Media' objects, which can be Books or Magazines
    private static List<Media> catalog = new ArrayList<>();

    // Scanner for user input
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. View Catalog");
            System.out.println("4. Exit");

            try {
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        addMagazine();
                        break;
                    case 3:
                        viewCatalog(); // This method is now updated
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        input.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number!");
                input.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    // This method adds a Book to the 'List<Media>'
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = input.nextLine();
        System.out.print("Enter author name: ");
        String author = input.nextLine();

        catalog.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    // This method adds a Magazine to the 'List<Media>'
    public static void addMagazine() {
        System.out.print("Enter magazine title: ");
        String title = input.nextLine();
        System.out.print("Enter issue number: ");

        try {
            int issue = input.nextInt();
            input.nextLine(); // clear buffer

            catalog.add(new Magazine(title, issue));
            System.out.println("Magazine added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Issue number must be a number!");
            input.nextLine(); // clear invalid input
        }
    }

    // === THIS IS THE UPDATED METHOD ===
    /**
     * View all items in the catalog, grouped by their type.
     * This method loops through the list multiple times
     * to group the output.
     */
    public static void viewCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty!");
            return;
        }

        // --- Books Section ---
        System.out.println("\n--- Books ---");
        boolean booksFound = false;
        int bookCount = 1;

        // First loop: Find and print only the Book objects
        for (Media item : catalog) {
            // We check the type using 'instanceof'
            if (item instanceof Book) {
                // item.getDetails() is polymorphic!
                // It will call the Book's getDetails method.
                System.out.println("  " + bookCount + ". " + item.getDetails());
                booksFound = true;
                bookCount++;
            }
        }
        if (!booksFound) {
            System.out.println("  (No books in catalog)");
        }

        // --- Magazines Section ---
        System.out.println("\n--- Magazines ---");
        boolean magazinesFound = false;
        int magazineCount = 1;

        // Second loop: Find and print only the Magazine objects
        for (Media item : catalog) {
            // We check the type using 'instanceof'
            if (item instanceof Magazine) {
                System.out.println("  " + magazineCount + ". " + item.getDetails());
                magazinesFound = true;
                magazineCount++;
            }
        }
        if (!magazinesFound) {
            System.out.println("  (No magazines in catalog)");
        }
    }
}
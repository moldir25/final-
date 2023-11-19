import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    private static final List<Book> bookList = new ArrayList<>();
    private static final List<Student> studentList = new ArrayList<>();
    private static final ExternalServiceAdapter externalServiceAdapter = new LibraryAdapter();
    private static final Library library = new Library(externalServiceAdapter);
    private static final LibraryDecorator loggingLibrary = new LoggingLibraryDecorator(library);
    private static final LibraryDecorator securedLibrary = new SecurityLibraryDecorator(loggingLibrary);

    public static void main(String[] args) {
        showCLI();
    }

    private static void showCLI() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline character

            switch (choice) {
                case 1:
                    securedLibrary.addNewStudent(studentList);
                    break;
                case 2:
                    loggingLibrary.addNewBook(bookList);
                    break;
                case 3:
                    securedLibrary.StudentsINFO(studentList);
                    break;
                case 4:
                    loggingLibrary.booksINFO(bookList);
                    break;
                case 5:
                    securedLibrary.giveBook(studentList, bookList);
                    break;
                case 6:
                    loggingLibrary.returnBook(studentList, bookList);
                    break;
                case 7:
                    securedLibrary.close(studentList, bookList);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Welcome to the Library");
        System.out.println("Choose an option:");
        System.out.println("1. Add new student");
        System.out.println("2. Add new book");
        System.out.println("3. Show all students");
        System.out.println("4. Show all books");
        System.out.println("5. Give a book to a student");
        System.out.println("6. Return a book to the library");
        System.out.println("7. Close the app");
    }
}

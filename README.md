# Final Project Documentation

**Software Design Patterns**  
*Kazmagambetova Moldir*  
*Astana IT University*  
*SE-2213*  
*Prof: Aigerim Berdimurat*

Astana, 2023

## Library Project Documentation

### Overview
The project is a simple library management system implemented in Java. It includes classes and interfaces to represent books, students, librarians, and external services, as well as features such as borrowing and returning books, displaying information, and interacting with external data sources.

**Project Information:**
- **Project Name:** Library Management System
- **Programming Language:** Java

**Project Idea:**
The primary idea behind the project is to create a functional library management system where librarians can manage books, students, and interactions within the library. It involves the use of object-oriented principles and design patterns to achieve modularity, extensibility, and maintainability in the codebase.

**Purpose of the Work:**
1. **Book Management:** Keep track of books, including their titles, authors, quantities, ISBNs, and publication years.
2. **Student Management:** Manage student information, such as IDs, names, and the books they have borrowed.
3. **Library Interaction:** Allow librarians to add and remove books, give books to students, and receive returned books.
4. **External Service Integration:** Implement an external service adapter to fetch book and student information from external sources.
5. **Decorator Pattern:** Utilize the decorator pattern to add logging and security features to the library operations.

**Objectives of the Work:**
1. **Modular Design:** Create classes and interfaces with well-defined responsibilities for a modular and organized codebase.
2. **User Interaction:** Provide a user-friendly command-line interface for librarians to interact with the library functionalities.
3. **External Data Fetching:** Implement an external service adapter to simulate fetching data from an external source.
4. **Decorator Implementation:** Utilize the decorator pattern to extend the functionality of the library service dynamically.
5. **Code Documentation:** Include meaningful comments and documentation to help developers understand the purpose and usage of each component.

The project aims to demonstrate fundamental concepts of object-oriented programming, design patterns, and basic library management functionalities in a console-based Java application. It serves as a learning exercise and a foundation for further development and expansion.

## Main Body

### Adapter Pattern:
**Description:**
Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

**Role and Functions:**
- Allows incompatible interfaces to work together.
- Acts as a bridge between two incompatible interfaces.

**Code Relationship:**
LibraryAdapter acts as an adapter between the Library class and an external service by implementing the ExternalServiceAdapter interface.
##
public interface ExternalServiceAdapter {
    List<Book> fetchBooksFromExternalService();
    Student fetchStudentInfoFromExternalService(int studentId);
}

# Factory Method Pattern:

## Description:

Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## Role and Functions:

- Provides an interface for creating instances in a superclass.
- Allows a class to delegate the responsibility of instantiating its instances to its subclasses.

## Code Relationship:

LibraryFactory contains a factory method (`createLibraryService`) for creating instances of LibraryService with different decorators.
##
public class LibraryFactory {

    public LibraryService createLibraryService(String type, ExternalServiceAdapter externalServiceAdapter) {
        if (type.equalsIgnoreCase("logging")) {
            return new LoggingLibraryDecorator(new Library(externalServiceAdapter));
        } else if (type.equalsIgnoreCase("security")) {
            return new SecurityLibraryDecorator(new Library(externalServiceAdapter));
        } else {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}

# Observer Pattern:

## Description:

Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

## Role and Functions:

- Defines a dependency between objects without making them tightly coupled.
- Allows multiple objects to listen for changes in another object.

## Code Relationship:

Observer interface, Subscriber interface, and Student class are part of the Observer pattern, allowing students to be notified of changes in the library (Librarian acts as the subject).

##
public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();
}

public interface Observer {
    void update(String message);
    void update(int message);
}

# Singleton Pattern:

## Description:

Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

## Role and Functions:

- Guarantees a single instance of a class.
- Provides a global access point to that instance.

## Code Relationship:

The Singleton class is used to create a single instance (LibraryArchive) accessible globally.

##
public final class Singleton {
    public static String value;
    private static Singleton instance;
    LibraryArchive Archivee = new LibraryArchive();

    private Singleton(String value) {
        // Initialization logic
        // ...

        this.value = value;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}

# Strategy Pattern

## Description:

Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

## Role and Functions:

- Defines a family of algorithms, encapsulates each algorithm, and makes them interchangeable.
- Allows a client to choose an algorithm from a family of algorithms at runtime.

## Code Relationship:

The idea of dynamically choosing different behaviors (e.g., through decorators) aligns with the Strategy pattern.
##
public interface BorrowingStrategy {
    void borrowBook(Book book);
}

public class StandardBorrowingStrategy implements BorrowingStrategy {
    @Override
    public void borrowBook(Book book) {
        // Implementation of the standard borrowing strategy
    }
}

public class ExtendedBorrowingStrategy implements BorrowingStrategy {
    @Override
    public void borrowBook(Book book) {
        // Implementation of the extended borrowing strategy
    }
}

public class Student {
    private BorrowingStrategy borrowingStrategy;

    public Student(BorrowingStrategy borrowingStrategy) {
        this.borrowingStrategy = borrowingStrategy;
    }

    public void borrowBook(Book book) {
        borrowingStrategy.borrowBook(book);
    }
}
# Conclusion

The Library Management System project is a Java-based application that incorporates various design patterns to create a modular and extensible system. The primary patterns utilized include the Decorator pattern for adding dynamic features to the library service, the Adapter pattern for interfacing with external services, and the Observer pattern for handling interactions between librarians and students.

## Outcomes & Challenges

Adapting the design to accommodate future changes posed a challenge. The solution involved carefully choosing design patterns to ensure flexibility without compromising the simplicity of the system.

## Future Improvements

- Implement actual communication with external services, such as online book databases or student information systems, to enhance the realism and functionality of the system.
- Extend the logging and security features to provide more detailed information and robust protection for sensitive operations.
- Develop a GUI to provide a more user-friendly and visually appealing interface for librarians and students to interact with the system.
- Integrate a database to store persistent data, ensuring that information about books, students, and library activities is preserved across sessions.
##
![Alt текст](111\KITAPHANA.png)

[References:](https://refactoring.guru/design-patterns/strategy)
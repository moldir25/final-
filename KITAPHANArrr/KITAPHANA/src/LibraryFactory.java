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

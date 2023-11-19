import java.util.ArrayList;
import java.util.List;

public class Librarian implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private List<Book> availableBooks = new ArrayList<>();

    public void addBook(Book book) {
        availableBooks.add(book);
        notifySubscribers();
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
        notifySubscribers();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

}

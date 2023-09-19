package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped  // one instance of bean for application
public class BookRepository {

    /* Inject configuration proprety named "books.genre".
    The application will attempt to fetch the value of this configuration property.
    If the property is not found, it will use the default value.
     */
    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;


    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Practising Quarkus", "Antonio", 2020, genre),
                new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre));
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
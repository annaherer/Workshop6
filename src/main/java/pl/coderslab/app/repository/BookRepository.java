package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
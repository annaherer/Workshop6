package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.repository.BookRepository;

@Component
public class BookConverter implements Converter<String, Book> {
    @Autowired
   BookRepository articleRepository;

    @Override
    public Book convert(String source) {
        return articleRepository.findById(Long.parseLong(source)).get();
    }
}
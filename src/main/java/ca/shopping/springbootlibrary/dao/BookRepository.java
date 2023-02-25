package ca.shopping.springbootlibrary.dao;

import ca.shopping.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
// TODO
//  The BookRepository interface extends the JpaRepository interface, which provides a set of CRUD (Create, Read, Update, Delete) methods for working with entities in the database. The BookRepository interface inherits these methods and provides specific ones for working with Book entities.
public interface BookRepository extends JpaRepository<Book,Long> {
}

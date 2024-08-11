package ssd.Entities.Author.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("authorRepository")
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);

    Author findById(long authorId);
}

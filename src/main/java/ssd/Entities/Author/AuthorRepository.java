package ssd.Entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("authorRepository")
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);

    Author findById(long authorId);
}

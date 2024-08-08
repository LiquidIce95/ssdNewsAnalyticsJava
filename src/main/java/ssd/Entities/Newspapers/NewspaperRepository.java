package ssd.Entities.Newspapers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("newspaperRepository")
public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {
    Newspaper findByName(String name);

    Newspaper findById(long newspaperId);
}

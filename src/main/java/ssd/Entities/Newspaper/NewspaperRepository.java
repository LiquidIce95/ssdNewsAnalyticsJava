package ssd.Entities.Newspaper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository("newspaperRepository")
public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {
    List<Newspaper> findByName(String name);

    Newspaper findById(long newspaperId);
}

package ssd.Entities.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("publisherRepository")
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String publisherName);

    Publisher findById(long publisherId);
}

package ssd.Entities.Publisher.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("publisherRepository")
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findByName(String publisherName);

    Publisher findById(long publisherId);
}

package ssd.Entities.Publisher.Raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("publisherRawRepository")
public interface PublisherRawRepository extends JpaRepository<PublisherRaw, Long> {
}

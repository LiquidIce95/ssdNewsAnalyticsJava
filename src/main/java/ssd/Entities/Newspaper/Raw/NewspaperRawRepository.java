package ssd.Entities.Newspaper.Raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("newspaperRawRepository")
public interface NewspaperRawRepository extends JpaRepository<NewspaperRaw, Long> {
}

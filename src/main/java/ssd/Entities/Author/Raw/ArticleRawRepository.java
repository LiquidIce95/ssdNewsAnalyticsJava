package ssd.Entities.Author.Raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("authorRawRepository")
public interface ArticleRawRepository extends JpaRepository<AuthorRaw, Long> {
}

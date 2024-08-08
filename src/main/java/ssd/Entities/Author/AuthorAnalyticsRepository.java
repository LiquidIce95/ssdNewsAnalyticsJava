package ssd.Entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("authorAnalyticsRepository")
public interface AuthorAnalyticsRepository extends JpaRepository<AuthorAnalytics, Long> {
}

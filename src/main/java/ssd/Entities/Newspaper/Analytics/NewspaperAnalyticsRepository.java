package ssd.Entities.Newspaper.Analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("newspaperAnalyticsRepository")
public interface NewspaperAnalyticsRepository extends JpaRepository<NewspaperAnalytics, Long> {
}

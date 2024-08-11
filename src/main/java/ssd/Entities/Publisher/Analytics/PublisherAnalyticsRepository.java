package ssd.Entities.Publisher.Analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("publisherAnalyticsRepository")
public interface PublisherAnalyticsRepository extends JpaRepository<PublisherAnalytics, Long> {
}

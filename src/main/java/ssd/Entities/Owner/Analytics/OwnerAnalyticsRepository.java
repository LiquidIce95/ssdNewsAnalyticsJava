package ssd.Entities.Owner.Analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ownerAnalyticsRepository")
public interface OwnerAnalyticsRepository extends JpaRepository<OwnerAnalytics, Long> {
}

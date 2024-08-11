package ssd.Entities.Owner.Analytics;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Analytics.AnalyticsRepository;

@Repository("ownerAnalyticsRepository")
public interface OwnerAnalyticsRepository extends AnalyticsRepository<OwnerAnalytics>{
}

package ssd.Entities.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("topicAnalyticsRepository")
public interface TopicAnalyticsRepository extends JpaRepository<TopicAnalytics, Long> {
}

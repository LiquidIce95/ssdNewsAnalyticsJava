package ssd.Entities.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("topicRepository")
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Topic findByName(String name);

    Topic findById(long topicId);
}

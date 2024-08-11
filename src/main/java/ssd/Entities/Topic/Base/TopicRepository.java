package ssd.Entities.Topic.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("topicRepository")
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByName(String name);

    Topic findById(long topicId);
}

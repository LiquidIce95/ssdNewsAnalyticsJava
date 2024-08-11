package ssd.Entities.Topic.Base;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Base.BaseEntityRepository;



@Repository("topicRepository")
public interface TopicRepository extends BaseEntityRepository<Topic>{
}

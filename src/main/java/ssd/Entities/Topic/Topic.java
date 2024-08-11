package ssd.Entities.Topic;

import javax.persistence.*;

import ssd.Entities.BaseEntity;
import ssd.Entities.Topic.Analytics.TopicAnalytics;


@Entity
@Table(name = "topic")
public class Topic extends BaseEntity<TopicAnalytics>{

}

package ssd.Entities.Topic.Base;

import javax.persistence.*;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.Entities.Topic.Analytics.TopicAnalytics;


@Entity
@Table(name = "topic")
public class Topic extends BaseEntity<TopicAnalytics>{

}

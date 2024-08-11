package ssd.Entities.Publisher;

import javax.persistence.*;

import ssd.Entities.BaseEntity;
import ssd.Entities.Publisher.Analytics.PublisherAnalytics;

@Entity
@Table(name = "publisher")
public class Publisher extends BaseEntity<PublisherAnalytics> {

}

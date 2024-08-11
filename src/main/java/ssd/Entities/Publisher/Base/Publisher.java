package ssd.Entities.Publisher.Base;

import javax.persistence.*;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.Entities.Publisher.Analytics.PublisherAnalytics;

@Entity
@Table(name = "publisher")
public class Publisher extends BaseEntity<PublisherAnalytics> {

}

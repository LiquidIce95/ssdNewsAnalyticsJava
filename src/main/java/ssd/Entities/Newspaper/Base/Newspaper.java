package ssd.Entities.Newspaper.Base;

import javax.persistence.*;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.Entities.Newspaper.Analytics.NewspaperAnalytics;


@Entity
@Table(name = "newspaper")
public class Newspaper extends BaseEntity<NewspaperAnalytics> {

}

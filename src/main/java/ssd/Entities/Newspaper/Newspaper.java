package ssd.Entities.Newspaper;

import javax.persistence.*;

import ssd.Entities.BaseEntity;
import ssd.Entities.Newspaper.Analytics.NewspaperAnalytics;


@Entity
@Table(name = "newspaper")
public class Newspaper extends BaseEntity<NewspaperAnalytics> {

}

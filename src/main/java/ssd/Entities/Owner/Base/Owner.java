package ssd.Entities.Owner.Base;

import javax.persistence.*;

import ssd.AbstractClasses.BaseEntity;
import ssd.Entities.Owner.Analytics.OwnerAnalytics;


@Entity
@Table(name = "owner")
public class Owner extends BaseEntity<OwnerAnalytics> {

}

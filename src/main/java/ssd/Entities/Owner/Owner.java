package ssd.Entities.Owner;

import javax.persistence.*;

import ssd.Entities.BaseEntity;
import ssd.Entities.Owner.Analytics.OwnerAnalytics;


@Entity
@Table(name = "owner")
public class Owner extends BaseEntity<OwnerAnalytics> {

}

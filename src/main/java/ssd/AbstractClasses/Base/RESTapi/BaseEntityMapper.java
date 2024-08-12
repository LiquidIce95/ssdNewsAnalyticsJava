package ssd.AbstractClasses.Base.RESTapi;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.AbstractClasses.Analytics.Analytics;

public interface BaseEntityMapper<E extends BaseEntity<? extends Analytics>, D> {

    D convertEntityToGetDTO(E entity);

}

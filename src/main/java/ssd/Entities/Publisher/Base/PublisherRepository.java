package ssd.Entities.Publisher.Base;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Base.BaseEntityRepository;

@Repository("publisherRepository")
public interface PublisherRepository extends BaseEntityRepository<Publisher> {
}

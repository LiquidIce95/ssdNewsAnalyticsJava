package ssd.Entities.Newspaper.Base;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Base.BaseEntityRepository;



@Repository("newspaperRepository")
public interface NewspaperRepository extends BaseEntityRepository<Newspaper> {
}

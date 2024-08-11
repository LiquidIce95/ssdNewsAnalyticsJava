package ssd.Entities.Author.Base;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Base.BaseEntityRepository;



@Repository("authorRepository")
public interface AuthorRepository extends BaseEntityRepository<Author> {

}

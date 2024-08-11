package ssd.Entities.Owner.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Base.BaseEntityRepository;

import java.util.List;


@Repository("ownerRepository")
public interface OwnerRepository extends BaseEntityRepository<Owner> {
}

package ssd.Entities.Owner.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("ownerRepository")
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findByName(String name);

    Owner findById(long ownerId);
}

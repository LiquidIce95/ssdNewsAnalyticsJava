package ssd.Entities.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ownerRepository")
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByName(String name);

    Owner findById(long ownerId);
}

package ssd.Entities.Owner.Raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ownerRawRepository")
public interface OwnerRawRepository extends JpaRepository<OwnerRaw, Long> {
}

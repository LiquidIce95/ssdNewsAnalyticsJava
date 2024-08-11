package ssd.AbstractClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface EntityRawRepository<T extends EntityRaw> extends JpaRepository<T, Long> {

    Optional<T> findById(Long id);

    Optional<T> findByUrl(String url);
}

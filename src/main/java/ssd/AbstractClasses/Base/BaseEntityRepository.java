package ssd.AbstractClasses.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ssd.AbstractClasses.Analytics.Analytics;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity<? extends Analytics>> extends JpaRepository<T, Long> {

    List<T> findByName(String name);

    Optional<T> findById(Long id);
}

package ssd.AbstractClasses.Analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface AnalyticsRepository<T extends Analytics> extends JpaRepository<T, Long> {

    Optional<T> findById(Long id);
}

package ttl.larku.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttl.larku.domain.ScheduledClass;

@Repository
public interface ClassRepo extends JpaRepository<ScheduledClass, Integer> {
}

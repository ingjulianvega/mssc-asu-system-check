package ingjulianvega.ximic.msscasusystemcheck.domain.repositories;

import ingjulianvega.ximic.msscasusystemcheck.domain.SystemCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface SystemCheckRepository extends JpaRepository<SystemCheckEntity, UUID>, JpaSpecificationExecutor<SystemCheckEntity> {
    List<SystemCheckEntity> findByVisitId(UUID visitId);
}

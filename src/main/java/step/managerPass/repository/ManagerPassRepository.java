package step.managerPass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import step.managerPass.entity.ManagerPassEntity;
import step.managerPass.entity.ServiceEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ManagerPassRepository extends JpaRepository<ManagerPassEntity, Long> {


    ArrayList<ManagerPassEntity> findAll();

    ManagerPassEntity findManagerPassEntityById(Long id);

    ArrayList<ManagerPassEntity> findAllByServiceEntity(ServiceEntity serviceEntity);

    @Query("SELECT u FROM ManagerPassEntity u WHERE u.typeManagerPass.eTypeManagerPass = SERVICE")
    ArrayList<ManagerPassEntity> findAllByStatusService();

    @Query("SELECT u FROM ManagerPassEntity u WHERE u.typeManagerPass.eTypeManagerPass = SECRET")
    ArrayList<ManagerPassEntity> findAllByStatusSecret();
}

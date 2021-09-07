package step.managerPass.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import step.managerPass.Entity.ServiceEntity;

import java.util.List;
@Repository
public interface ServiceEntityRepository extends PagingAndSortingRepository<ServiceEntity,Long> {
    List<ServiceEntity> findAllByName(@Param("name") String name);
    List<ServiceEntity> findAll();


}

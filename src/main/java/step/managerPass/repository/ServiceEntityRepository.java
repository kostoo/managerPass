package step.managerPass.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import step.managerPass.entity.ServiceEntity;

import java.util.ArrayList;
@Repository
public interface ServiceEntityRepository extends PagingAndSortingRepository<ServiceEntity,Long> {
    ArrayList<ServiceEntity> findAllByName(@Param("name") String name);
    ArrayList<ServiceEntity> findAll();


}

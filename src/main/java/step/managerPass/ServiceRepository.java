package step.managerPass;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service,Integer> {
    List<Service> findAllByName(@Param("name") String name);
    List<Service> findAll();
}

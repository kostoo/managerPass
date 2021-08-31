package step.managerPass;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "services" ,path = "service")
public interface ServiceRepository extends PagingAndSortingRepository<Service,Integer> {
    List<Service> findAllByName(@Param("name") String name);
    List<Service> findAll();
}

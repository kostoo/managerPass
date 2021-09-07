package step.managerPass.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import step.managerPass.Entity.ServiceEntity;
import step.managerPass.Entity.UserEntity;

import java.util.List;

@Repository
public interface UserEntityRepository extends PagingAndSortingRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    List<UserEntity> findAllByLastName(@Param("last_name") String last_name);

    UserEntity findUserEntityById_user(@Param("id_user") Long id);
}

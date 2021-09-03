package step.managerPass.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import step.managerPass.Entity.Service;
import step.managerPass.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findAllByLast_name(@Param("last_name") String last_name);
}

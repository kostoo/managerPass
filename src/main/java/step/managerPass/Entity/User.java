package step.managerPass.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Employee")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_user;

    private String name;
    private String last_name;

    @ManyToMany
    private Set<Access> groupAccess;
}

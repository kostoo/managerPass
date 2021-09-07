package step.managerPass.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;

    private String name;
    @Column(name = "last_name")
    private String lastName;

    public UserEntity(Long id_user, String name, String last_name) {
        this.id_user = id_user;
        this.name = name;
        this.lastName = last_name;
    }

    @ManyToMany
    private Set<AccessEntity> groupAccess;
}

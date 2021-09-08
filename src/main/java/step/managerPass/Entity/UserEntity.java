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
@Builder
@Table(name = "employee")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long idUser;

    private String name;
    @Column(name = "last_name")
    private String lastName;

    public UserEntity(Long idUser, String name, String lastName) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
    }

    @ManyToMany
    private Set<AccessEntity> groupAccess;
}

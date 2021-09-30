package step.managerPass.entity;

import lombok.Data;
import step.managerPass.entity.eNum.ERole;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;


}

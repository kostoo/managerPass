package step.managerPass.entity;

import lombok.Data;

import step.managerPass.entity.eNum.ETypeManagerPass;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class TypeManagerPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @NotBlank
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ETypeManagerPass eTypeManagerPass;
}

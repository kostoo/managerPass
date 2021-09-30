package step.managerPass.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;


}

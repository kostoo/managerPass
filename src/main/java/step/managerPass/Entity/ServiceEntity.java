package step.managerPass.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;
    private String name;
    private String comment;

    public ServiceEntity(Long id_service, String name) {
        this.id_service = id_service;
        this.name = name;
    }
}

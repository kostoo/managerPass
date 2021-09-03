package step.managerPass.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;
    private String name;
    private String comment;

}

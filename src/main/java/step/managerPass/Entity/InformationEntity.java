package step.managerPass.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "information")
public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_information;

    private String name;


}

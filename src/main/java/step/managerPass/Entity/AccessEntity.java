package step.managerPass.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "access")
public class AccessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}


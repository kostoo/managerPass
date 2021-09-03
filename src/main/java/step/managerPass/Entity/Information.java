package step.managerPass.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Information {

    //  встроенный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_information;

    private String name;


}

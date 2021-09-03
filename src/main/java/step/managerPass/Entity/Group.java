package step.managerPass.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Group {
    //  встроенный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

}

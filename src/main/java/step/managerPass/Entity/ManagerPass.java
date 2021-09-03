package step.managerPass.Entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ManagerPass {
    //  встроенный ключ
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_on")
    private Date createdOn = new Date();

    private String login;

    private String pass;

    private Integer id_information;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_information", referencedColumnName = "id_information")
    private Information information;

}

package step.managerPass.Entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "manager_pass")
public class ManagerPassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    private ServiceEntity service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_on")
    private Date createdOn = new Date();

    private String login;

    private String pass;

    private String comment;

}

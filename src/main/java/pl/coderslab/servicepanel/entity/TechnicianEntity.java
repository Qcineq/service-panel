package pl.coderslab.servicepanel.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TechnicianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToMany
    private List<ReportEntity> reportEntity;

}

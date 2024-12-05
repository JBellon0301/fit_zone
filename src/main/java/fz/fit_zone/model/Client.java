package fz.fit_zone.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    private String name_client;
    private String last_name_client;
    private String email_client;
    private String password_client;

    private Date date_registered = new Date();
    private Date date_modified;

    // Relación con la tabla Membership
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Membership membership;

    // Relación con la tabla HealthProfile
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private HealthProfile healthProfile;

    private String createdBy;
    private Boolean isActive = true;
}
package fz.fit_zone.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class HealthProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfile;

    private Double weight;
    private Double height;
    private String medicalConditions;
    private String fitnessGoals;
    private String preferredActivities;
    private Date lastActivityDate;

    // Relation with Client
    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;
}

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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetails;

    private String address;
    private String phoneNumber;
    private Date dateOfBirth;

    @OneToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "idEmployee")
    private Employee employee;
}

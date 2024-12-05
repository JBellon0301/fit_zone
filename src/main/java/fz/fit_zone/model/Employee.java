package fz.fit_zone.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nameEmployee;
    private String lastNameEmployee;
    private String emailEmployee;
    private String passwordEmployee;
    private Date date_registered = new Date();

    @Enumerated(EnumType.STRING) 
    private Role role;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;
}

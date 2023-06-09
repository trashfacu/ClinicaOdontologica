package com.example.clinicaOdontologica.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Patients")
@Getter @Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate dischargeDate;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "residence_id")
    private Residence residence;
    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();
}



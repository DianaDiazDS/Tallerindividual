package edu.co.tallerindividual.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mascotas")
public class Mascota  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMascota;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String raza;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_dueño" )
    @JsonIgnore
    private Dueño dueño;
    //veterinario

    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "idMascota"),
            inverseJoinColumns = @JoinColumn(name = "idVeterianario")
    )
    private List<Veterinario> veterinarios;
//carnet
//    @OneToOne(mappedBy = "mascota",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)

    @OneToOne(mappedBy = "mascota",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarnet")
    @JsonIgnore
    private Carnet carnet;


    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }
}

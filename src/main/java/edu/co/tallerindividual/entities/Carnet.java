package edu.co.tallerindividual.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "carnets")
public class Carnet  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCarnet;

    @Column(length = 50, nullable = false)
    private String descripcion;

    @OneToOne
    @JsonIgnore
    private Mascota mascota;


    public Integer getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(Integer idCarnet) {
        this.idCarnet = idCarnet;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}

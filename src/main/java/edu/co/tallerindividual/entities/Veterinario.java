package edu.co.tallerindividual.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "veterinarios")
public class Veterinario  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVeterinario;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer telefono;


    //mascota
//    @ManyToMany(mappedBy = "veterinarios", cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "veterinarios")
    @JsonIgnore
    private List<Mascota> mascotas;




    public Integer getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}

package edu.co.tallerindividual.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "dueños")
public class Dueño {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer telefono;

    @Column(length = 50,nullable = false)
    private String direcccion;

//    @OneToMany(mappedBy = "dueño",fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Mascota> mascota;

    //    @OneToMany(mappedBy = "dueño",cascade = CascadeType.All)
    @OneToMany(mappedBy = "dueño", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Mascota> mascotas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}

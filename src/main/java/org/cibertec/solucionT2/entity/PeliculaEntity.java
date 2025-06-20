package org.cibertec.solucionT2.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "peliculas")
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String genero;

    private int stock;

    @OneToMany(mappedBy = "pelicula")
    private List<DetalleAlquilerEntity> detalles;

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<DetalleAlquilerEntity> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleAlquilerEntity> detalles) {
        this.detalles = detalles;
    }
}
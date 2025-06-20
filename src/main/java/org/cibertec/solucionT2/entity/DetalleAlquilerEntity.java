package org.cibertec.solucionT2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_alquiler")
@IdClass(DetalleAlquilerId.class)
public class DetalleAlquilerEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    private AlquilerEntity alquiler;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private PeliculaEntity pelicula;

    private int cantidad;

    public AlquilerEntity getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(AlquilerEntity alquiler) {
        this.alquiler = alquiler;
    }

    public PeliculaEntity getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaEntity pelicula) {
        this.pelicula = pelicula;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
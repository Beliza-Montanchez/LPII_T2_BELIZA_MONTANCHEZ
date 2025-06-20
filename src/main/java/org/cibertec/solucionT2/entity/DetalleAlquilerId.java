package org.cibertec.solucionT2.entity;

import java.io.Serializable;
import java.util.Objects;

public class DetalleAlquilerId implements Serializable {
    private Integer alquiler;
    private Integer pelicula;

    public DetalleAlquilerId() {}

    public DetalleAlquilerId(Integer alquiler, Integer pelicula) {
        this.alquiler = alquiler;
        this.pelicula = pelicula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleAlquilerId)) return false;
        DetalleAlquilerId that = (DetalleAlquilerId) o;
        return Objects.equals(alquiler, that.alquiler) &&
               Objects.equals(pelicula, that.pelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alquiler, pelicula);
    }
}

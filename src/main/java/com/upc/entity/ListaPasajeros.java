package com.upc.entity;

import javax.persistence.*;

@Entity
@Table(name="ListaPasajeros")
public class ListaPasajeros {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", nullable = false)
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "cotizacion_id", nullable = false)
    private Cotizacion cotizacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }
}

package com.platzimarket.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {

    @EmbeddedId
    private ComprasProcuctoPK id;

    private Integer cantidad;
    private Integer total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;


    public ComprasProcuctoPK getId() {
        return id;
    }

    public void setId(ComprasProcuctoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

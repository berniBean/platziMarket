package com.platzimarket.persistence.entity;

import javax.persistence.*;

import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;
    private String estado;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
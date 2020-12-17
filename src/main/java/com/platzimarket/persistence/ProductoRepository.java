package com.platzimarket.persistence;

import com.platzimarket.persistence.crud.ProductoCrudRespository;
import com.platzimarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository//se encarga de interactuar con la base de datos
//@Componet(Es una generalizacion de las anotaciones spring)
public class ProductoRepository {
    private ProductoCrudRespository productoCrudRespository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRespository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return  productoCrudRespository.findByIdCategoriaOrderByNombreAsc( idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRespository.findByCantidadStockLesThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int idProducto){//usando crudRepository
        return productoCrudRespository.findById(idProducto);
    }

    public  Producto save(Producto producto){
        return productoCrudRespository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRespository.deleteById(idProducto);
    }

}

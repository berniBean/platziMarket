package com.platzimarket.persistence;

import com.platzimarket.domain.Product;
import com.platzimarket.domain.repository.ProductRepository;
import com.platzimarket.persistence.crud.ProductoCrudRespository;
import com.platzimarket.persistence.entity.Producto;
import com.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository//se encarga de interactuar con la base de datos
//@Componet(Es una generalizacion de las anotaciones spring)
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRespository productoCrudRespository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRespository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public void delete(int productId){
        productoCrudRespository.deleteById(productId);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRespository.findByIdCategoriaOrderByNombreAsc( categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
         Optional<List<Producto>>productos=  productoCrudRespository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {

        return productoCrudRespository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRespository.save(producto));
    }



}

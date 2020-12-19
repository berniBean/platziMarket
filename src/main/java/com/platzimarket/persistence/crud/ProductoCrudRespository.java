package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRespository extends CrudRepository<Producto,Integer> {
          List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
          Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad_stock, boolean estado);
}

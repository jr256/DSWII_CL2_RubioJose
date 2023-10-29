package com.edu.cibertec.DSWII_CL2_RubioJose.repository;

import com.edu.cibertec.DSWII_CL2_RubioJose.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByProductoname(String productoName);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> filtrarProductosEntre10y100();

    @Query(value ="SELECT * FROM producto WHERE YEAR(fechavencimiento) = 2024",
            nativeQuery = true)
    List<Producto> filtrarVencimiento2024();

}


package com.senac.Estacionamentoweb.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface CarroRepository extends JpaRepository<CarroEntity, Integer> {
    
}

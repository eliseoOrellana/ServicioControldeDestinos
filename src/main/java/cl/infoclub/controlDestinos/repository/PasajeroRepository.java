package cl.infoclub.controlDestinos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.infoclub.controlDestinos.entity.Pasajero;
@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Integer>{

}

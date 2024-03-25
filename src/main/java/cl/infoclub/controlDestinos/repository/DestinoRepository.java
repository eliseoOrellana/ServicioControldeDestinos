package cl.infoclub.controlDestinos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.infoclub.controlDestinos.entity.Destino;
@Repository
public interface DestinoRepository  extends JpaRepository<Destino, Integer>{
	

}

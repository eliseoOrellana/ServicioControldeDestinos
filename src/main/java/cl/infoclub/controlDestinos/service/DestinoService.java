package cl.infoclub.controlDestinos.service;

import cl.infoclub.controlDestinos.dto.DestinoDTO;
import cl.infoclub.controlDestinos.entity.Destino;

public interface DestinoService {

	void save(Destino destino);
	
	DestinoDTO findAll();// revisar
}

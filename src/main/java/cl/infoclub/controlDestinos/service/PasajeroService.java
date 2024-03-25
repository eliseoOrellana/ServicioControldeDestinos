package cl.infoclub.controlDestinos.service;


import cl.infoclub.controlDestinos.dto.PasajeroDTO;
import cl.infoclub.controlDestinos.entity.Pasajero;

public interface PasajeroService {
	//min 1.09 

	PasajeroDTO findALL();//devolviendo obejeto enriquesido con mas datos de obetner directo de la lista
	
	void save(Pasajero pasajero);

	
}
package cl.infoclub.controlDestinos.service.impl;



import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.infoclub.controlDestinos.dto.PasajeroDTO;
import cl.infoclub.controlDestinos.entity.Pasajero;
import cl.infoclub.controlDestinos.repository.PasajeroRepository;
import cl.infoclub.controlDestinos.service.PasajeroService;


@Service
public class PasajeroServiceImpl implements PasajeroService{

	private static final Logger log = LoggerFactory.getLogger(PasajeroServiceImpl.class);
	@Autowired
	PasajeroRepository pasajeroRepository;
	PasajeroDTO respuesta;
	

	
	@Override
	@Transactional
	public void save(Pasajero pasajero) {
		respuesta=new PasajeroDTO("Ha ocurrido un error", "103",new ArrayList<Pasajero>());
		try {
			pasajeroRepository.save(pasajero);
			respuesta.setMensaje("Se ha adicionado un pasajero correctamente");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Servicio destino:error finAll");
		}
	}


	@Override
	@Transactional(readOnly = true)
	public PasajeroDTO findALL() {
		respuesta=new PasajeroDTO("Ha ocurrido un error", "103",new ArrayList<Pasajero>());
		try {
			respuesta.setPasajero(pasajeroRepository.findAll());
			respuesta.setMensaje(String.format("Se han encontrado %d pasajeros",pasajeroRepository.findAll().size()));
			respuesta.setCodigo("0");
			
		} catch (Exception e) {
			log.trace("Servicio destino:error finAll");
		}
		
		return respuesta;
	}
	
	
}

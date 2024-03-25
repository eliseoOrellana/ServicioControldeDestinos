package cl.infoclub.controlDestinos.service.impl;

import java.util.ArrayList;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.infoclub.controlDestinos.dto.DestinoDTO;
import cl.infoclub.controlDestinos.entity.Destino;
import cl.infoclub.controlDestinos.repository.DestinoRepository;
import cl.infoclub.controlDestinos.service.DestinoService;


@Service
public class destinoServiceImpl implements DestinoService{

	private static final Logger log = LoggerFactory.getLogger(destinoServiceImpl.class);
	@Autowired
	DestinoRepository destinoRepository;
	DestinoDTO respuesta;

	@Override
	@Transactional
	public void save(Destino destino) {
		respuesta=new DestinoDTO("Ha ocurrido un error", "103", new ArrayList<Destino>());
		try {
			destinoRepository.save(destino);
			respuesta.setMensaje("Se ha adicionado un destino correctamente");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Servicio destino:error finAll");
		}
	}
	

	@Override
	@Transactional(readOnly = true)//
	public DestinoDTO findAll() {
	
		respuesta=new DestinoDTO("ha ocurrido un error", "102", new ArrayList<Destino>());
		try {
		respuesta.setDestino(destinoRepository.findAll());//seteo de destino....devuelve un listado de destino
		respuesta.setMensaje(String.format("Se han encontrado %d destinos", destinoRepository.findAll().size()));
		respuesta.setCodigo("0"); //todo estas ok.
		} catch (Exception e) {
		log.trace("Servicio destino:error finAll");//revisar
		}
		return respuesta;
	}

	
	

}

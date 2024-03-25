package cl.infoclub.controlDestinos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.infoclub.controlDestinos.entity.Destino;
import cl.infoclub.controlDestinos.service.DestinoService;
import cl.infoclub.controlDestinos.service.PasajeroService;

@Controller
@RequestMapping("Destinos") //revisar despues ???
public class DestinoController {
	
	private static final Logger log = LoggerFactory.getLogger(DestinoController.class); //para hacer trazas de informacion, ver si es necesario
	
	@Autowired
	PasajeroService pasajeroService; //inyeccion de servicios
	
	@Autowired
	DestinoService destinoService;//inyeccion de servicios
	
	
	@GetMapping  ("/crear")   //revisar despues          
	public  ModelAndView crearDestino() {
		
		
		ModelAndView modelAndView = new ModelAndView("crear-destino");//REVISAR DE NUEVO
		modelAndView.addObject("destino", new Destino());
		modelAndView.addObject("pasajeros" , pasajeroService.findALL().getPasajero());
		
		return modelAndView;
	}

	@PostMapping ("/crear")
	public RedirectView crearDestino(@ModelAttribute Destino viaje) {
		
		destinoService.save(viaje);
		return new RedirectView("/Destinos");
	}
	
	@GetMapping
	public ModelAndView destinos () {
	ModelAndView modelAndView = new ModelAndView("destinos");
	modelAndView.addObject( "destinos" , destinoService.findAll().getDestino());//COPIE Y PEGUE
	return modelAndView;
	}
	
}

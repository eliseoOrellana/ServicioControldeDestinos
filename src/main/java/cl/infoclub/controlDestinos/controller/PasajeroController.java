package cl.infoclub.controlDestinos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.infoclub.controlDestinos.entity.Pasajero;
import cl.infoclub.controlDestinos.service.DestinoService;
import cl.infoclub.controlDestinos.service.PasajeroService;

@Controller
@RequestMapping ("Pasajeros")
public class PasajeroController {
	
	@Autowired
	private PasajeroService pasajeroService;
	
	@Autowired
	DestinoService destinoService;
	
	
	@GetMapping ("/crear")//
	public ModelAndView agregar () {
	ModelAndView modelAndView = new ModelAndView("crear-pasajero");
	modelAndView.addObject( "pasajero",  new Pasajero());
	return modelAndView;
	}
	@PostMapping ("/crear")
	public RedirectView agregar (@ModelAttribute Pasajero pasajero) {
	pasajeroService.save(pasajero);
	return new RedirectView("/Pasajeros");
	}
	@GetMapping
	public ModelAndView pasajeros () {
		ModelAndView modelAndView = new ModelAndView("pasajeros");
		modelAndView.addObject( "pasajeros" , pasajeroService.findALL().getPasajero());
		return modelAndView;
		}
	
	

}

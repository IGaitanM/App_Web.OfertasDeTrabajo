package net.IGaitanM.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.IGaitanM.model.Vacante;
import net.IGaitanM.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired                                 //Instancia de una clase de servicio
	private IVacantesService serviceVacantes;  //Atributo del tipo de la interfaz
	
	/**
	 * Método que crea un objeto de tipo lista, lo agrega al modelo y lo renderiza en la vista tabla html
	 * @return tabla
	 */
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "tabla"; //devuelve la vista tabla.html
	}
	
	/**
	 * Método que crea un objeto de tipo Vacante, lo agrega al modelo y lo renderiza en la vista detalle html
	 * @return detalle
	 */
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	/**
	 * Método que crea un objeto de tipo lista, agrega empleos a esa lista,
	 * lo agrega al modelo y lo renderiza en la vista listado html
	 * @return listado
	 */
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero  de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Comercial");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return "home";
	}

		
}

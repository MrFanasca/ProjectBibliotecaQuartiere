package org.generation.italy.bibliotecaQuartiere.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.generation.italy.bibliotecaQuartiere.model.Assegnazione;
import org.generation.italy.bibliotecaQuartiere.model.Libro;
import org.generation.italy.bibliotecaQuartiere.repository.AssegnazioneRepository;
import org.generation.italy.bibliotecaQuartiere.repository.LibroRepository;
import org.generation.italy.bibliotecaQuartiere.repository.VolontarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Volontario")
public class VolontarioController {

	@Autowired
	VolontarioRepository volontarioRepository;
	@Autowired
	AssegnazioneRepository assegnazioneRepository;
	@Autowired
	LibroRepository libroRepository;
	
	@GetMapping
	public String home(Model model) {
		
		ArrayList <Assegnazione> elencoAssegnazione = null;
		
		elencoAssegnazione = (ArrayList<Assegnazione>) assegnazioneRepository.findAssegnazione();
		
		model.addAttribute("elencoAssegnazione", elencoAssegnazione);
		
		return "/volontario/homepage";
	}
	
	@GetMapping("/elenco")
	public String elenco(Model model) {
		
		ArrayList <Libro> elencoLibri = null;
		
		elencoLibri = (ArrayList<Libro>) libroRepository.findAll();
		
		model.addAttribute("elencoLibri", elencoLibri);
		
		return "/volontario/elenco";
	}
	
	@GetMapping("/inserimento")
	public String inserisciLibro() {
		return "/volontario/inserimento";
	}
	
	@PostMapping("/aggiungi-libro") 
	public String aggiungiLibro(@ModelAttribute("libro") Libro l) {
		
		libroRepository.save(l);
		return "redirect:/Volontario/elenco";
	}
	
	@GetMapping("/cambiaStato/{id}")
	public String cambiaStato(@PathVariable String id) {
		
		Optional<Libro> optLibro = libroRepository.findById(id);
		if (optLibro.isPresent()) {
			
			Libro l = optLibro.get();
			
			if(l.getStato().equals("PR")) {
				
				l.setStato("TC");
			} else if(l.getStato().equals("TC")) {
				
				l.setStato("LI");
			}
			libroRepository.save(l);
			return "redirect:/Volontario";
		}
		else
			return "/volontario/!Stefano";
	}
	
}

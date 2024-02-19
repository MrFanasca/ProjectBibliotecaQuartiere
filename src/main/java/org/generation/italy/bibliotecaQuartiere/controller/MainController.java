package org.generation.italy.bibliotecaQuartiere.controller;

import org.generation.italy.bibliotecaQuartiere.security.DatabaseUserDetails;
import org.generation.italy.bibliotecaQuartiere.security.model.Ruolo;
import org.generation.italy.bibliotecaQuartiere.security.model.Utente;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping			//gestisce una richiesta GET all'indirizzo /	
	public String index(Authentication authentication, Model model) {
		DatabaseUserDetails dbUser=(DatabaseUserDetails) authentication.getPrincipal();
		Utente u=dbUser.getUtente();
		boolean volontario=false;
		boolean cittadino=false;
//		model.addAttribute("utente", u);
		for(Ruolo r:u.getRuoli()) {
			
			System.out.println("Ruolo: " + r.getName());
			if (r.getName().equals("cittadino")) {
				cittadino=true;
				System.out.println("entro cittadino/volontario");
			}
				
			if (r.getName().equals("volontario"))
				volontario=true;
		}
		
		if (cittadino) {
			System.out.println("ento volontario");
			return "redirect:/Volontario";
		} 
		
		System.out.println("entro cittadino2");
		return "redirect:/servlet/cittadino/elenco-libri";
	}
}

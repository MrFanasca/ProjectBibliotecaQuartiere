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
			if (r.getName().equals("cittadino"))
				cittadino=true;
			if (r.getName().equals("volontario"))
				volontario=true;
		}
		
		if (volontario) {
			System.out.println("ento volontario");
			return "redirect:/Volontario";
		} else if (cittadino) {
			System.out.println("entro cittadino");
			return "redirect:/servlet/cittadino/elenco-libri";
		}
		System.out.println("entro cittadino2");
		return "redirect:/servlet/cittadino/elenco-libri";
	}
}

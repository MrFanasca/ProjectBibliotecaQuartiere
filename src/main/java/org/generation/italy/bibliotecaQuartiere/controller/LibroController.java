package org.generation.italy.bibliotecaQuartiere.controller;

import org.generation.italy.bibliotecaQuartiere.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LibroController {

	@Autowired
	LibroRepository libroRepository;
	
	
}

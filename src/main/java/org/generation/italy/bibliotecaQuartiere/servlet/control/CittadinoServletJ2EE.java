package org.generation.italy.bibliotecaQuartiere.servlet.control;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.generation.italy.bibliotecaQuartiere.security.DatabaseUserDetails;
import org.generation.italy.bibliotecaQuartiere.security.model.Utente;
import org.generation.italy.bibliotecaQuartiere.servlet.model.BibliotecaModelException;
import org.generation.italy.bibliotecaQuartiere.servlet.model.JdbcConnection;
import org.generation.italy.bibliotecaQuartiere.servlet.model.dao.AssegnazioneDao;
import org.generation.italy.bibliotecaQuartiere.servlet.model.dao.CittadinoDao;
import org.generation.italy.bibliotecaQuartiere.servlet.model.dao.LibroDao;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Assegnazione;
import org.generation.italy.bibliotecaQuartiere.servlet.model.entity.Libro;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@WebServlet(urlPatterns = { "/servlet/cittadino/elenco-libri", "/servlet/cittadino/assegna-libro", "/servlet/cittadino/storico-libri", "/servlet/cittadino/libri-prenotati"})
public class CittadinoServletJ2EE extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private CittadinoDao cittadinoDao;
	private AssegnazioneDao assegnazioneDao;
	private LibroDao libroDao;


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		Connection dbConnection = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost",
				"3306", "biblioteca_quartiere", "root", "").getDbConnection();
		this.libroDao = new LibroDao(dbConnection);
		this.cittadinoDao = new CittadinoDao(dbConnection);
		this.assegnazioneDao = new AssegnazioneDao(dbConnection);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		executeAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		executeAction(request, response);

	}

	protected void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String actionName = request.getServletPath()+request.getPathInfo();
		
		switch (actionName.toLowerCase().trim()) {
		
		
		case "/servlet/cittadino/assegna-libro":
			actionAssegnaLibro(request, response);
			break;

		case "/servlet/cittadino/elenco-libri":
			actionRicercaElencoLibri(request, response);
			break;
			
		case "/servlet/cittadino/libri-prenotati":
			actionLibriPrenotati(request, response);
			break;

		}

	}	
	
	private void actionRicercaElencoLibri(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServletException {

		
		try {

			List<Libro> listLibri = libroDao.loadLibriLiberi();
			request.setAttribute("listLibri", listLibri);
			request.setAttribute("pagina", "elencoLibri");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/elenco-libri.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	private void actionAssegnaLibro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServletException {

		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
				DatabaseUserDetails dbUser=(DatabaseUserDetails) authentication.getPrincipal();
				Utente u=dbUser.getUtente();
			    Integer nrTessera = u.getCittadino().getNumeroTessera();
				System.out.println("numero t:" + nrTessera);
		
		String codiceLibro = request.getParameter("codice-libro") != null ? request.getParameter("codice-libro") : "";
		String cambioStato = request.getParameter("stato") != null ? request.getParameter("stato") : "";

		try {

			
			//Triggers.checkBeforeInsertAssegnazione(codiceLibro, nrTessera);
			Assegnazione assegnazione = new Assegnazione(nrTessera, codiceLibro);
			Libro libro = new Libro(codiceLibro, cambioStato);
			assegnazioneDao.addAssegnazione(assegnazione);
			libroDao.updateStato(libro);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Messages.jsp");

			dispatcher.forward(request, response);

		} catch (BibliotecaModelException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	private void actionLibriPrenotati(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServletException {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
				DatabaseUserDetails dbUser=(DatabaseUserDetails) authentication.getPrincipal();
				Utente u=dbUser.getUtente();
			    Integer nrTessera = u.getCittadino().getNumeroTessera();
				System.out.println("numero t:" + nrTessera);
		try {

			

			List<Assegnazione> listPrenotazioni = assegnazioneDao.mostraPrenotazioni(nrTessera);
			request.setAttribute("listPrenotazioni", listPrenotazioni);
			request.setAttribute("pagina", "libriPrenotati");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/libri-prenotati.jsp");

			dispatcher.forward(request, response);
			
		} catch (BibliotecaModelException e) {

			System.out.println(e.getMessage());
		}
	}
	
}

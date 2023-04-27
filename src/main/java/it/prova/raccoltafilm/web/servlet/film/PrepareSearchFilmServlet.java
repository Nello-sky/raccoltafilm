package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.RegistaService;

@WebServlet("/PrepareSearchFilmServlet")
public class PrepareSearchFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegistaService registaService;

	public PrepareSearchFilmServlet() {
		this.registaService = MyServiceFactory.getRegistaServiceInstance();
	}
	
	
	
	//deve portarmi solamente a film.show
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// controllare cosa succede se non sono presenti registi, che poi significa anche nessun film.........
		try {
			request.setAttribute("registi_list_attribute", registaService.listAllElements());
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/film/search.jsp").forward(request, response);
	}

}

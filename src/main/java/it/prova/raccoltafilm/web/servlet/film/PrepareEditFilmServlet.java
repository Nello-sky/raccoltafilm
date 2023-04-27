package it.prova.raccoltafilm.web.servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.service.FilmService;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.RegistaService;

/**
 * Servlet implementation class PrepareEditFilmServlet
 */
@WebServlet("/PrepareEditFilmServlet")
public class PrepareEditFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmService filmService;
	private RegistaService registaService;

	public PrepareEditFilmServlet() {
		this.filmService = MyServiceFactory.getFilmServiceInstance();
		this.registaService = MyServiceFactory.getRegistaServiceInstance();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idFilmToUpdate = request.getParameter("idFilm");

		if (!NumberUtils.isCreatable(idFilmToUpdate)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			response.sendRedirect(request.getContextPath() + "/home?operationResult=ERROR");
			return;
		}

		try {
			Film filmInstance = filmService.caricaSingoloElemento(Long.parseLong(idFilmToUpdate));

			if (filmInstance == null) {
				// scegliere se solo admin
				response.sendRedirect(
						request.getContextPath() + "/ExecuteListFilmServlet?operationResult=NOT_FOUND");
				return;
			}
			request.setAttribute("registi_list_attribute", registaService.listAllElements());
			request.setAttribute("update_film_attr", filmInstance);
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/home?operationResult=ERROR");
			return;
		}

		request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
	}


}

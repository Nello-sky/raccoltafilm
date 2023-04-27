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
import it.prova.raccoltafilm.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteEditFilmServlet
 */
@WebServlet("/ExecuteEditFilmServlet")
public class ExecuteEditFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmService filmService;
	private RegistaService registaService;

	public ExecuteEditFilmServlet() {
		this.filmService = MyServiceFactory.getFilmServiceInstance();
		this.registaService = MyServiceFactory.getRegistaServiceInstance();

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idFilmToUpdate = request.getParameter("idFilmUpdate");

		if (!NumberUtils.isCreatable(idFilmToUpdate)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		// estraggo input
		String titoloParam = request.getParameter("titolo");
		String genereParam = request.getParameter("genere");
		String dataPubblicazioneParam = request.getParameter("dataPubblicazione");
		String minutiDurataParam = request.getParameter("minutiDurata");
		String registaIdParam = request.getParameter("regista.id");

		Long idFilmUpdate = Long.parseLong(idFilmToUpdate);


		//
		Film example = UtilityForm.createFilmFromParams(titoloParam, genereParam, minutiDurataParam, dataPubblicazioneParam, registaIdParam);

		example.setId(idFilmUpdate);

		//

		try {
			// se la validazione non risulta ok
			if (!UtilityForm.validateFilmBean(example)) {
				request.setAttribute("registi_list_attribute", registaService.listAllElements());
				request.setAttribute("update_film_attr", filmService.caricaSingoloElemento(idFilmUpdate));
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
				return;
			}

			// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
			// occupiamoci delle operazioni di business
			filmService.aggiorna(example);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/film/edit.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListFilmServlet?operationResult=SUCCESS");
	}
}

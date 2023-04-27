package it.prova.raccoltafilm.web.servlet.regista;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.raccoltafilm.model.Regista;
import it.prova.raccoltafilm.service.MyServiceFactory;
import it.prova.raccoltafilm.service.RegistaService;
import it.prova.raccoltafilm.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteEditRegistaServlet
 */
@WebServlet("/ExecuteEditRegistaServlet")
public class ExecuteEditRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegistaService registaService;

	public ExecuteEditRegistaServlet() {
		this.registaService = MyServiceFactory.getRegistaServiceInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idRegistaToUpdate = request.getParameter("idRegistaUpdate");

		if (!NumberUtils.isCreatable(idRegistaToUpdate)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		// estraggo input
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String nickNameParam = request.getParameter("nickName");
		String dataDiNascitaParam = request.getParameter("dataDiNascita");
		String sessoParam = request.getParameter("sesso");

		Long idRegistaUpdate = Long.parseLong(idRegistaToUpdate);

		// Sesso sessoParsed = StringUtils.isNotBlank(sessoParam) ?
		// Sesso.valueOf(sessoParam) : null;

		//
		Regista example = UtilityForm.createRegistaFromParams(nomeParam, cognomeParam, nickNameParam,
				dataDiNascitaParam, sessoParam);

		example.setId(idRegistaUpdate);

		//

		try {
			// se la validazione non risulta ok
			if (!UtilityForm.validateRegistaBean(example)) {
				request.setAttribute("update_regista_attr", registaService.caricaSingoloElemento(idRegistaUpdate));
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
				return;
			}

			// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
			// occupiamoci delle operazioni di business
			registaService.aggiorna(example);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListRegistaServlet?operationResult=SUCCESS");
	}

}

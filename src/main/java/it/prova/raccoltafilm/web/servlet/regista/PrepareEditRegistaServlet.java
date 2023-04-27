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

/**
 * Servlet implementation class PrepareEditRegistaServlet
 */
@WebServlet("/PrepareEditRegistaServlet")
public class PrepareEditRegistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegistaService registaService;

	public PrepareEditRegistaServlet() {
		this.registaService = MyServiceFactory.getRegistaServiceInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idRegistaToUpdate = request.getParameter("idRegista");

		if (!NumberUtils.isCreatable(idRegistaToUpdate)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			response.sendRedirect(request.getContextPath() + "/home?operationResult=ERROR");
			return;
		}

		try {
			Regista registaInstance = registaService.caricaSingoloElemento(Long.parseLong(idRegistaToUpdate));

			if (registaInstance == null) {
				// scegliere se solo admin
				response.sendRedirect(
						request.getContextPath() + "/ExecuteListRegistaServlet?operationResult=NOT_FOUND");
				return;
			}

			request.setAttribute("update_regista_attr", registaInstance);
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/home?operationResult=ERROR");
			return;
		}

		request.getRequestDispatcher("/regista/edit.jsp").forward(request, response);
	}

}

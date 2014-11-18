package servlets;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionOServicio;

@WebServlet("/AltaRec")
public class AltaReclamo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AltaReclamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GestionOServicio gs = new GestionOServicio();
		
		int idRec = gs.crearReclamo(
				req.getParameter("dni"),
				req.getParameter("nombre"),
				req.getParameter("apellido"),
				req.getParameter("direccion"),
				req.getParameter("telefono"),
				req.getParameter("mail"),
				req.getParameter("desc"));
		
	    req.setAttribute("idRec", idRec);
	    RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/rec.jsp");
	    dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

    
}

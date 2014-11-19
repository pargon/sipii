package servlets;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionOServicio;

@WebServlet("/AsignaODSRec")
public class AsignaODSReclamo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AsignaODSReclamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GestionOServicio gs = new GestionOServicio();
		
		gs.asignarReclamoODS( Integer.parseInt(req.getParameter("idODS")), 
							Integer.parseInt(req.getParameter("idRec")));
		
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
	    dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

    
}

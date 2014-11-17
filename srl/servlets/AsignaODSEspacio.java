package servlets;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionOServicio;

@WebServlet("/AsignaODSEsp")
public class AsignaODSEspacio extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AsignaODSEspacio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GestionOServicio gs = new GestionOServicio();
		
		gs.asignarEspacioODS(Integer.parseInt(req.getParameter("idODS")), 
							req.getParameter("calle"),
							req.getParameter("chapa"));
		
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/index.jsp");
	    dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

    
}

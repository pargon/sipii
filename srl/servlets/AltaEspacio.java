package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionEspacio;
import controlador.GestionOServicio;

@WebServlet("/AltaEspacio")
public class AltaEspacio extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AltaEspacio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GestionEspacio gs = new GestionEspacio();
		
	
		
//	    req.setAttribute("idODS", idODS);
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/ods.jsp");
	    dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

    
}

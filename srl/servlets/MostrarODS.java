package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionOServicio;
import Beans.bOrdendeServicio;

@WebServlet("/MostrarODS")
public class MostrarODS extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/mostrar_ods.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		GestionOServicio gs = new GestionOServicio();
		
		List<bOrdendeServicio> bfs = (List<bOrdendeServicio>)gs.mostrarODS();
		
		req.setAttribute("ODSs", bfs);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/jsp/mostrar_ods.jsp");
		rd.forward(req, resp);

	}
	
}

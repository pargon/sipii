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
import Beans.bReclamo;

@WebServlet("/MostrarRec")
public class MostrarRec extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/jsp/mostrar_rec.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		GestionOServicio gs = new GestionOServicio();
		
		List<bReclamo> bfs = (List<bReclamo>)gs.mostrarRec();
		
		req.setAttribute("Recs", bfs);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/jsp/mostrar_rec.jsp");
		rd.forward(req, resp);

	}
	
}

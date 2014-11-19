package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionEspacio;
import controlador.GestionOServicio;
import Beans.bEspacio;
import Beans.bOrdendeServicio;

@WebServlet("/MostrarEsp")
public class MostrarEsp extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrar_esp.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		GestionEspacio gs = new GestionEspacio();
		
		List<bEspacio> bfs = (List<bEspacio>)gs.buscarEspacioXEstado();
		
		req.setAttribute("Esps", bfs);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/mostrar_esp.jsp");
		rd.forward(req, resp);

	}
	
}

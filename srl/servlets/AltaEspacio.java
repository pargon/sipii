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
		String tipoE = req.getParameter("tipo");
		
		String ce = req.getParameter("cantero_ele");
		boolean cantEl = false;
		
		if (ce != null && ce.equals("cantero_ele"))
			cantEl = true;
				
		int idEsp = gs.crearEspacio(
				req.getParameter("calle"),
				req.getParameter("chapa"),
				req.getParameter("tipocat"),
				req.getParameter("latitud"),
				req.getParameter("longitud"),
				Float.valueOf( req.getParameter("largo_plant")),
				Float.valueOf( req.getParameter("ancho_plant")),
				req.getParameter("tipo"),
				cantEl);
		
		int idArbol;
		if(tipoE.equals("Arbol")){
			String []Atributos = req.getParameterValues("check_arbol");

			idArbol = gs.crearArbol(idEsp, 
					req.getParameter("altura"),
					0,
					Float.valueOf(req.getParameter("perimetro")),
					req.getParameter("inclinacion"),
					req.getParameter("orientacion"),
					req.getParameter("dens_foll"),
					req.getParameter("color_foll"),
					req.getParameter("estado_copa"),
					req.getParameter("cav_basal"),
					req.getParameter("cav_media"),
					req.getParameter("cav_alta"),
					req.getParameter("destrucc_tr"),
					req.getParameter("interfer_tr"),
					req.getParameter("destrucc_ra"),
					req.getParameter("interfer_ra"),
					Atributos);
		}else{
			idArbol = gs.crearArbol(); 
			gs.asignarArbolEspacio(idArbol, idEsp);
		}
	
		
	    req.setAttribute("idEsp", idEsp);
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/esp.jsp");
	    dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

    
}

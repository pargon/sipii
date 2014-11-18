package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionOServicio;
import controlador.GestionUsuario;

@WebServlet("/Login")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GestionUsuario gu = new GestionUsuario();

		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		
		
		if(gu.usuarioExiste(user))
			if(gu.usuarioContrOk(user, pass))
			{
			    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/index.jsp");
			    dispatcher.forward(req, resp);
			}
			else
			{
			    req.setAttribute("mensaje", "Contraseña incorrecta");
			    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/login.jsp");
			    dispatcher.forward(req, resp);
			}
		else
		{
		    req.setAttribute("mensaje", "Usuario "+ user + " inexistente");
		    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/login.jsp");
		    dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

    
}

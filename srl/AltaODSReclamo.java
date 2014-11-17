

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.GestionOServicio;

@WebServlet("/AltaODSRec")
public class AltaODSReclamo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AltaODSReclamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		GestionOServicio gs = new GestionOServicio();
		
		int idODS = gs.crearODS( Integer.parseInt( req.getParameter("tarea")),
					req.getParameter("anot"));
		
	    req.setAttribute("idODS", idODS);
	    RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/ods.jsp");
	    dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public class Input {

	    int value = 0;

	    public void setInput(int i){
	        this.value = i;
	    }

	    public int getInput(){
	        return this.value;
	    }
	}
    public Vector getValues(Input i){
        Vector v = new Vector<String>();
        if(i.getInput()==0)
            v.add("worked");
        else
           v.add("it hurts");
        return v;
    }
	
}

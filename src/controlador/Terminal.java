package controlador;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terminal {

	@Id
	private String ter;

	public Terminal() {
		// TODO Auto-generated constructor stub
	}

	public String getTer() {
		return ter;
	}

	public void setTer(String ter) {
		this.ter = ter;
	}

	
}

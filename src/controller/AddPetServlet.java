package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;

/**
 * Servlet implementation class AddPetServlet
 */
@WebServlet("/addPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name"); 
		String species = request.getParameter("species");
		
		if(!name.isEmpty() && !species.isEmpty()) {
			Pet p = new Pet(name, species);
			PetHelper ph = new PetHelper();
			ph.addPet(p);
		}
		else {
			System.out.println("Field(s) must not be blank.");
		}
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

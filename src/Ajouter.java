
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzariaa.Pizza;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ajouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza("MARGHERITA", 10));
		pizzaList.add(new Pizza("SALMON", 12));
		pizzaList.add(new Pizza("NAPOLITAINE", 12));
		pizzaList.add(new Pizza("FORMAGGI", 12));
		pizzaList.add(new Pizza("BOLOGNAISE", 13));
		pizzaList.add(new Pizza("TONO", 14));
		pizzaList.add(new Pizza("FRUITTI DI MARE", 14));

		if (session == null) {
			session = request.getSession(true);
			session.setAttribute("pizzas", new ArrayList<>());
		}
		
			List<Pizza> pizzas = (List<Pizza>) session.getAttribute("pizzas");
			List<Pizza> choiceList = new ArrayList<>();
			String[] choices = request.getParameterValues("pizza");
			
			for(int i=0; i<choices.length; i++) {
				for(Pizza p : pizzaList) {
					if(p.getNom().equals(choices[i])) {
						choiceList.add(p);
						break;
					}
				}
			}
			pizzas.addAll(choiceList);
			session.setAttribute("pizzas", pizzas);
		
		response.sendRedirect("/pizzariaa/menu.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
